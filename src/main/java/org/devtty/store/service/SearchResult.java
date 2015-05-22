package org.devtty.store.service;

import org.devtty.store.entity.Client;

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
