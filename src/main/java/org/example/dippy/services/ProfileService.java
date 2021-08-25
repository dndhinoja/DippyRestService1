package org.example.dippy.services;

import org.example.dippy.dao.Repository;
import org.example.dippy.models.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    Map<String, Profile> profileMap = Repository.getProfiles();

    public ProfileService() {
        profileMap.put("Dipali",new Profile(1L,"Dipali","Dipali","Dhinoja"));
    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<>(profileMap.values());
    }

    public Profile getProfile(String profileName){
        return profileMap.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setProfileId(profileMap.size()+1L);
        System.out.println(profile.getProfileId());
        profileMap.put(profile.getProfileName(),profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty())
            return null;
        return profileMap.put(profile.getProfileName(),profile);
        //return profile;
    }

    public Profile deleteProfile(String profileName){
        return profileMap.remove(profileName);
    }

    public List<Profile> getSubList(int start, int size) {
        List<Profile> profileSubList = new ArrayList<>(profileMap.values());
        return profileSubList.subList(start,start+size);
    }
}
