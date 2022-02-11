package org.devtty.store.view;

import java.io.StringReader;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.scope.WindowScoped;
import org.devtty.store.entity.Store;
import org.devtty.store.service.StoreRepository;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Model
@WindowScoped
public class StoreView extends AbstractPersistableIndexView<StoreRepository, Store>{
    
    @Inject StoreRepository storeRepository;
    @Inject Logger logger;
    
    private TreeNode holidays;
    private TreeNode[] selectedHolidays;
    
    public Class<? extends ViewConfig> create(){
        setDetail(new Store());
        return Pages.Stores.Edit.class;
    }

    public Class<? extends ViewConfig> edit(){
        setDetail(getSelected().get(0));
        return Pages.Stores.Edit.class;
    }

    public TreeNode getHolidays() {
        if(holidays == null){
            
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://raw.githubusercontent.com/commenthol/date-holidays/master/data/holidays.json");
            Response response = target.request(MediaType.APPLICATION_JSON).get();
            String value = response.readEntity(String.class);

            
            holidays = new DefaultTreeNode();
            /*
            JsonReader reader = Json.createReader(new StringReader(value));
            JsonObject o = reader.readObject();
            
            JsonObject holiday = o.getJsonObject("holidays");
            
            for(String s : holiday.keySet()){
                JsonObject country = holiday.getJsonObject(s);
                JsonString englishCountryName = country.getJsonObject("names").getJsonString("en");
                logger.info("Holiday KEsy: " + englishCountryName);
                if(englishCountryName!=null)
                    //TreeNode countryNode = 
                    new DefaultTreeNode(englishCountryName.toString(), holidays);
            }

            
            reader.close();
            
            response.close();
            
            //logger.info("REST VA: " + value);
              */      
            
        }
        return holidays;
    }

    public void setHolidays(TreeNode holidays) {
        this.holidays = holidays;
    }

    public TreeNode[] getSelectedHolidays() {
        return selectedHolidays;
    }

    public void setSelectedHolidays(TreeNode[] selectedHolidays) {
        this.selectedHolidays = selectedHolidays;
    }
    
    
}
