package org.example.dippy.models;


import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class Link {

    private String linkName;
    private String rel;

    public Link(){

    }

    public Link(String linkName, String rel) {
        super();
        this.linkName = linkName;
        this.rel = rel;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
