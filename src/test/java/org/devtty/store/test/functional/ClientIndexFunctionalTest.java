package org.devtty.store.test.functional;

import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@RunWith(Arquillian.class)
public class ClientIndexFunctionalTest extends FunctionalTest{
    
    /*@FindBy(id = "clientIndexForm:table:clientTable")
    private GrapheneElement datatable;
    
    @FindBy(id = "clientIndexForm:new")
    private GrapheneElement newBtn;
    
    @FindBy(id = "clientIndexForm:edit")
    private GrapheneElement editBtn;
    
    @FindBy(id = "clientIndexForm:delete")
    private GrapheneElement deleteBtn;*/
    
    @Page
    private ClientIndexPage page;
    
    
    
    @Test
    public void test(){
        browser.get(deploymentUrl.toExternalForm() + "/clients/index.jsf");
        assertTrue(page.getDatatable().isPresent());
        assertTrue(page.getNewBtn().isPresent());
        assertTrue(page.getNewBtn().isDisplayed());
        assertTrue(page.getNewBtn().isEnabled());
        assertTrue(page.getEditBtn().isPresent());
        assertTrue(page.getEditBtn().isDisplayed());
        assertFalse(page.getEditBtn().isEnabled());
        assertTrue(page.getDeleteBtn().isPresent());
        assertTrue(page.getDeleteBtn().isDisplayed());
        assertFalse(page.getDeleteBtn().isEnabled());
        
                
        //assertTrue("clientTable not present", datatable.isPresent());
        //assertTrue("newBtn not present", newBtn.isPresent());
        //assertTrue(newBtn.isDisplayed());
        //assertTrue(newBtn.isEnabled());
        //assertTrue("editBtn not present", editBtn.isPresent());
        //assertTrue(editBtn.isDisplayed());
        //assertFalse(editBtn.isEnabled());
        //assertTrue("deleteBtn not present", deleteBtn.isPresent());
        //assertTrue(deleteBtn.isDisplayed());
        //assertFalse(deleteBtn.isEnabled());
    }
    
}
