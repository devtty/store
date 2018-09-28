package org.devtty.store.test.functional;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class ClientIndexPage {

    @FindBy(id = "clientIndexForm:table:clientTable")
    private GrapheneElement datatable;
    
    @FindBy(id = "clientIndexForm:new")
    private GrapheneElement newBtn;
    
    @FindBy(id = "clientIndexForm:edit")
    private GrapheneElement editBtn;
    
    @FindBy(id = "clientIndexForm:delete")
    private GrapheneElement deleteBtn;

    public GrapheneElement getDatatable() {
        return datatable;
    }

    public GrapheneElement getNewBtn() {
        return newBtn;
    }

    public GrapheneElement getEditBtn() {
        return editBtn;
    }

    public GrapheneElement getDeleteBtn() {
        return deleteBtn;
    }
    
    
    
}
