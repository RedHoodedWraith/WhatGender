package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;

public class UserProfile {

    @Id
    public long id;
    public String fullName;
    public String preferredName;
    // Might have to be replaced if only primitive types allowed
    public Gender currentGender;
    public Pronouns currentPronouns;
    private final HashMap<String, Gender> genderOptions = new HashMap<>();
    private final HashMap<String, Pronouns> pronounsOptions = new HashMap<>();

    public UserProfile() {
    }

    public UserProfile(String fullName, String preferredName) {
        this.fullName = fullName;
        this.preferredName = preferredName;
    }

    @Override
    public String toString() {
        return String.format("User[id='%s', preferredName='%s']", id, preferredName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public Gender getCurrentGender() {
        return currentGender;
    }

    public void setCurrentGender(String newCurrentGender) {
        this.currentGender = getGenderByName(newCurrentGender);
    }

    public void setCurrentGender(Gender currentGender) {
        if(genderOptions.containsValue(currentGender))
            this.currentGender = currentGender;
    }

    public void addGender(Gender gender) {
        genderOptions.put(gender.getGenderName(), gender);
    }

    public void removeGender(String genderToRemove) {
        genderOptions.remove(genderToRemove);
    }

    public Gender getGenderByName(String genderName) {
        return genderOptions.get(genderName);
    }
}
