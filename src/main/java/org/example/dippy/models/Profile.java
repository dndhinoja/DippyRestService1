package org.example.dippy.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

    Long profileId;
    String profileName;
    String firstName;
    String lastName;

    public Profile() {
    }

    public Profile(Long profileId, String profileName, String firstName, String lastName) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
