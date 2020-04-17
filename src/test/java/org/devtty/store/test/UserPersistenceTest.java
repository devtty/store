package org.devtty.store.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

import org.devtty.store.entity.User;

@RunWith(Arquillian.class)
public class UserPersistenceTest {

    @Deployment
    public static Archive<?> createDeployment() {
	return ShrinkWrap.create(WebArchive.class, "test.war")
	    .addPackage(User.class.getPackage())
	    .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
	    .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private static final String[] USER_LOGINS = {
	"user11",
	"user21",
	"user31"
    };

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Before
    public void preparePersistenceTest() throws Exception {
	clearData();
	insertData();
	startTransaction();
    }

    private void clearData() throws Exception{
	utx.begin();
	em.joinTransaction();
	System.out.println("Dumping old records");
	em.createQuery("delete from User").executeUpdate();
	utx.commit();
    }

    private void insertData() throws Exception{
	utx.begin();
	em.joinTransaction();
	System.out.println("Inserting records");
	
	for(String login : USER_LOGINS){
	    User user = new User();
	    user.setLogin(login);
            user.setName(login + "login");
            user.setEmail(login + "@devtty.de");
            user.setPass(login + "pass");
	    em.persist(user);
	}
	
	utx.commit();
	em.clear();
    }

    private void startTransaction() throws Exception{
	utx.begin();
	em.joinTransaction();
    }


    @After
    public void commitTransaction() throws Exception{
	utx.commit();
    }

    @Test
    public void shouldFindAllUsersUsingJpqlQuery(){
	String fetchingAllUsersInJpql = "select u from User u order by u.id";
	System.out.println("Selecting (using jpql)");
	List<User> users = em.createQuery(fetchingAllUsersInJpql, User.class).getResultList();

	System.out.println("Found " + users.size() + " users (using JPQL):");
	assertContainsAllUsers(users);
    }

    private static void assertContainsAllUsers(Collection<User> retrievedUsers){
	Assert.assertEquals(USER_LOGINS.length, retrievedUsers.size());
	final Set<String> retrievedUserLogins = new HashSet<String>();
	for(User user : retrievedUsers){
	    System.out.println("* " + user);
	    retrievedUserLogins.add(user.getLogin());
	}
	Assert.assertTrue(retrievedUserLogins.containsAll(Arrays.asList(USER_LOGINS)));
    }
}
