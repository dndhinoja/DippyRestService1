package org.example.dippy.resources;

import org.example.dippy.models.BeanAnnotation;
import org.example.dippy.models.Profile;
import org.example.dippy.services.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
public class MyProfileResource {

    ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAllProfile(@BeanParam BeanAnnotation beanAnnotation)
    {
        if(beanAnnotation.getStart()>=0 && beanAnnotation.getSize()>0){
            return profileService.getSubList(beanAnnotation.getStart(),beanAnnotation.getSize());
        }
        return profileService.getAllProfiles();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile){
        return profileService.addProfile(profile);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public  Profile getProfile(@PathParam("profileName") String profileName){
        return profileService.getProfile(profileName);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile){
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileService.deleteProfile(profileName);
    }
}
