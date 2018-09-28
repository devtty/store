package org.devtty.store.test.functional;

import org.jboss.arquillian.graphene.GrapheneElement;
import org.jboss.arquillian.junit.Arquillian;
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
    
    
    
}
