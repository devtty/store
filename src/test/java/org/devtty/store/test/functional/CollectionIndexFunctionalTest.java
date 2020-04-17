package org.devtty.store.test.functional;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@RunWith(Arquillian.class)
public class CollectionIndexFunctionalTest extends FunctionalTest{
    
    @FindBy(id = "collectionIndexForm:table:collectionTable")
    private GrapheneElement datatable;
                     
    @Test
    public void test(){
        
        browser.get(deploymentUrl.toExternalForm() + "/items/index.jsf");
        
        //assertTrue("itemtable not present", datatable.isPresent());
        assertTrue("fff" + browser.getTitle(), browser.getTitle().equals("Title"));
        
                
    }
    
}
