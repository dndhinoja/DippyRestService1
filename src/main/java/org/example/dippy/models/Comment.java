package org.example.dippy.models;

import java.util.Date;

public class Comment {

    Long commentId;
    String comment;
    Date createdDateComment;

    public Comment(Long commentId, String comment) {
        this.commentId = commentId;
        this.comment = comment;
        this.createdDateComment = new Date();
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedDateComment() {
        return createdDateComment;
    }

    public void setCreatedDateComment(Date createdDateComment) {
        this.createdDateComment = createdDateComment;
    }
}
