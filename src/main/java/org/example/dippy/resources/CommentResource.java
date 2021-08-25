package org.example.dippy.resources;

import org.example.dippy.models.Comment;
import org.example.dippy.models.Message;
import org.example.dippy.services.CommentService;
import org.example.dippy.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class CommentResource {

   CommentService commentService = new CommentService();

    /*@GET
    public String getComments(){
        return "hi Comment..";
    }*/

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId")Long messageId,@PathParam("commentId")Long commentId){
        return commentService.getComment(messageId,commentId);
    }

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") Long messageID){
        return commentService.getAllComments(messageID);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(@PathParam("messageId") Long messsageId,Comment comment){
        commentService.addComment(messsageId,comment);
        return comment;
    }

}
