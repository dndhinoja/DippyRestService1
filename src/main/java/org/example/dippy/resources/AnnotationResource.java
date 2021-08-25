package org.example.dippy.resources;

import org.example.dippy.models.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/inject")
public class AnnotationResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnnotation(@HeaderParam("Content-Type")String header,
                                @CookieParam("Cookie_3")String cookie,
                                @MatrixParam("param")String matrixParam){
        //@FormParam
        return "test  :  "+header+"  Cookie  :  "+cookie+"  MatrixParam  :  "+matrixParam;
    }

    @GET
    @Path("/contextDemo")
    public String get(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
        return "test" + uriInfo.getAbsolutePath() + httpHeaders.getCookies();
    }
}
