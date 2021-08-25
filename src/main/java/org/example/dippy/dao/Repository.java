package org.example.dippy.dao;

import org.example.dippy.models.Message;
import org.example.dippy.models.Profile;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long,Message> getMessages(){
        return messages;
    }

    public static Map<String,Profile> getProfiles(){
        return profiles;
    }
}
