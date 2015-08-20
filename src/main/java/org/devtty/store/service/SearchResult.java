package org.devtty.store.service;

import org.devtty.store.entity.Client;
import org.devtty.store.entity.Item;
import org.devtty.store.entity.User;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class SearchResult {

    public static final String SR_CLIENT = "Client";
    public static final String SR_ITEM = "Item";
    public static final String SR_USER = "User";
    
    private String label;
    private Object value;
    private String type;
    
    public SearchResult(Client client) {
        this.label = client.getName();
        this.value = client;
        this.type = SR_CLIENT;
    }
    
    public SearchResult(Item item) {
        this.label = item.getName();
        this.value = item;
        this.type = SR_ITEM;
    }
    
    public SearchResult(User user) {
        this.label = user.getName();
        this.value = user;
        this.type = SR_USER;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
