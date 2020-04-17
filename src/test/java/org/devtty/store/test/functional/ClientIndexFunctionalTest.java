package org.devtty.store.test.functional;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

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
        assertFalse("Delete button shouldn't be enabled", page.getDeleteBtn().isEnabled());
    }
    
    @Test
    public void testTableHeaders(){
        browser.get(deploymentUrl.toExternalForm() + "/clients/index.jsf");
        GrapheneElement header = page.getDatatable().findElement(By.className("ui-datatable-header"));
        assertEquals("Table Header doesnt match", header.getText(), "Kunden");
        
        GrapheneElement head = page.getDatatable().findElement(By.id("clientIndexForm:table:clientTable_head"));
        GrapheneElement selectAllCheckbox = head.findElement(By.name("clientIndexForm:table:clientTable_checkbox"));
        assertTrue(selectAllCheckbox.isPresent());
        
    }
    
}
