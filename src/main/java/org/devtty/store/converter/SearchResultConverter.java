package org.devtty.store.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.devtty.store.entity.Client;
import org.devtty.store.entity.Item;
import org.devtty.store.entity.User;
import org.devtty.store.service.SearchResult;
import org.devtty.store.service.UserRepository;
import org.slf4j.Logger;


/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@FacesConverter("searchResultConverter")
public class SearchResultConverter implements Converter{
    
    private static final String DELIM = "|";
    
    @Inject UserRepository userRepository;    
    
    @Inject private Logger logger;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {       
        SearchResult result = null;
        if(string.startsWith(SearchResult.SR_USER)){
            User user = userRepository.findBy(extractId(string));
            result = new SearchResult(user);
        }
            
        return result;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null && o instanceof SearchResult){
            SearchResult result = (SearchResult) o;

            switch(result.getType()){
                case SearchResult.SR_CLIENT : return SearchResult.SR_CLIENT + DELIM + ((Client) result.getValue()).getId().toString();
                case SearchResult.SR_ITEM : return SearchResult.SR_ITEM + DELIM + ((Item) result.getValue()).getId().toString();
                case SearchResult.SR_USER : return SearchResult.SR_USER + DELIM + ((User) result.getValue()).getId().toString();
            }
        }
        return null;
    }
    
    private Long extractId(String string){
        String s = string.substring(string.indexOf(DELIM) + 1);
        return Long.parseLong(s);
    }
}
