package org.example.dippy.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@XmlRootElement
public class Message {

    Long messageId;
    String message;
    String author;
    Date createdDate;
    private static Map<Long,Comment> comments = new HashMap<>();
    List<Link> links = new ArrayList<>();
    List<javax.ws.rs.core.Link> links1 = new ArrayList<>();


    public Message() {
    }

    public Message(Long messageId, String message, String author) {
        this.messageId = messageId;
        this.message = message;
        this.author = author;
        this.createdDate = new Date();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlElement
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLinks(List<Link> links) {
        links = links;
    }


    public void addLink(String uri, String rel){
        Link link = new Link();
        link.setLinkName(uri);
        link.setRel(rel);
        links.add(link);
    }
}
