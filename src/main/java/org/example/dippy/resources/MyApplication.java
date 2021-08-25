package org.example.dippy.resources;

import org.example.dippy.models.Message;
import org.example.dippy.services.MessageService;
import org.glassfish.jersey.server.Uri;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Path("/message")
public class MyApplication {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> allMessage(@QueryParam("year") int year,
                                    @QueryParam("start")int start,
                                    @QueryParam("size")int size){
        if(year>0){
            return messageService.getMessageOfYear(year);
        }
        if(start>0 && size>0){
            return messageService.getMessageOfPagination(start,size);
        }
        return messageService.getAllMessages();
        //return Response.ok(messageService.getAllMessages()).build();
    }

    @GET
    @Path("/{messageId}")
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Message getMessage(@PathParam("messageId")Long id,@Context UriInfo uriInfo) throws Throwable {
        Message message =  messageService.getMessage(id);
        message.addLink(getUri(uriInfo, message),"self");
        message.addLink(getProfileUri(uriInfo,message),"profile");
        message.addLink(getCommentUri(uriInfo,message),"comment");
        return message;
    }

    private String getCommentUri(UriInfo uriInfo,Message message) {
        return uriInfo.getBaseUriBuilder()
                .path(MyApplication.class)
                .path(MyApplication.class,"getComment")
                .path(CommentResource.class)
                .resolveTemplate("messageId",message.getMessageId())
                .build()
                .toString();
    }

    private String getProfileUri(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                .path(MyProfileResource.class)
                .path(message.getAuthor())
                .build()
                .toString();
    }

    private String getUri(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                .path(MyApplication.class)
                .path(Long.toString(message.getMessageId()))
                .build()
                .toString();
    }

    @POST
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
        Message message1 = messageService.addMessage(message);
        //URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(message1.getMessageId())).build();
        //return Response.created(uri)
          //      .entity(message1)
            //    .build();
        return Response.status(Response.Status.CREATED).entity(message1).build();
        //return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId")Long id, Message message){
        message.setMessageId(id);
        return messageService.updateMessage(id,message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId")Long id,@Context UriInfo uriInfo){
        messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getComment(){
        return new CommentResource();
    }
}


/*@GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> allMessage(){
        return messageService.getAllMessages();
    }*/
//@Path("/{messageId}/name/{profileId}")
//public Message test(@PathParam("messageId")Long id,@PathParam("profileId")Long id1){
