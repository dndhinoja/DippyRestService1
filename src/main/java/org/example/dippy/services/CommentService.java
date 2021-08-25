package org.example.dippy.services;

import org.example.dippy.dao.Repository;
import org.example.dippy.exception.DataNotFoundException;
import org.example.dippy.models.Comment;
import org.example.dippy.models.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long,Message> messages = Repository.getMessages();
    public CommentService() {
    }




    public List<Comment> getAllComments(Long messageId){
        Map<Long,Comment> commentList = messages.get(messageId).getComments();
        return new ArrayList<>(commentList.values());
    }

    /*public Comment getComment(Long messageId,Long commentId){
        Error error = new Error("Not Found",1111,"Something Wrong");
        Response response = Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
        Message message = messages.get(messageId);
        if(message==null){
            throw new WebApplicationException(response);
        }
        Map<Long,Comment> commentList = messages.get(messageId).getComments();
        Comment comment = commentList.get(commentId);
        if(comment==null){
            throw new WebApplicationException(response);
        }
        return commentList.get(commentId);
    }*/

    public Comment getComment(Long messageId,Long commentId){
        Message message = messages.get(messageId);
        if(message==null){
            throw new DataNotFoundException("MessageId not found : "+messageId);
        }
        Map<Long,Comment> commentList = messages.get(messageId).getComments();
        Comment comment = commentList.get(commentId);
        if(comment==null){
            throw new DataNotFoundException("CommentID not found : "+commentId);
        }
        return commentList.get(commentId);
    }

    public Comment addComment(Long messageId,Comment comment){
        Map<Long,Comment> commentList = messages.get(messageId).getComments();
        comment.setCommentId(commentList.size()+1L);
        commentList.put(comment.getCommentId(),comment);
        return comment;
    }

    public Comment updateComment(Long messageId,Comment comment){
        Map<Long,Comment> commentList = messages.get(messageId).getComments();
        if(comment.getCommentId()<=0) {
            return null;
        }
        commentList.put(comment.getCommentId(),comment);
        return comment;
    }
    public Comment removeComment(Long commentId,Long messageId){
        Map<Long,Comment> commentList = messages.get(messageId).getComments();
        return commentList.remove(commentId);
    }
}
