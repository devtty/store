package org.devtty.store.service;

import org.devtty.store.entity.Client;
import org.devtty.store.entity.Item;
import org.devtty.store.entity.User;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
public class SearchResult {

    private String label;
    private Object value;
    private String type;
    
    public SearchResult(Client client) {
        this.label = client.getName();
        this.value = client;
        this.type = "Client";
    }
    
    public SearchResult(Item item) {
        this.label = item.getName();
        this.value = item;
        this.type = "Item";
    }
    
    public SearchResult(User user) {
        this.label = user.getName();
        this.value = user;
        this.type = "User";
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
