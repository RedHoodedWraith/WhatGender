package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.HashMap;


public class UserProfile {

    @Id
    public long id;
    private String fullName;
    private String nameToDisplay;
    private String preferredName;
    private GenderProfile currentGender;
    private Pronouns currentPronouns;
    private HashMap<String, GenderProfile> genderOptions;
    private HashMap<String, Pronouns> pronounsOptions;

    public UserProfile() {
        this.genderOptions = new HashMap<>();
        this.pronounsOptions = new HashMap<>();
    }

    public UserProfile(String fullName, String preferredName) {
        this();
        this.fullName = fullName;
        this.preferredName = preferredName;
        this.nameToDisplay = this.preferredName;
    }

    @Override
    public String toString() {
        return String.format("User[id='%s', preferredName='%s', fullName='%s', pronouns='%s', genders='%s']",
                id, preferredName, fullName, pronounsOptions.keySet(), genderOptions.keySet());
    }

    public Long getID() {
        return this.id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNameToDisplay() {
        return this.nameToDisplay;
    }

    public void setNameToDisplay(String nameToDisplay) {
        this.nameToDisplay = nameToDisplay;
    }

    public String getPreferredName() {
        return this.preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public boolean hasGender(String genderName) {
        return this.genderOptions.containsKey(genderName);
    }

    public GenderProfile getGenderByName(String genderName) {
        return this.genderOptions.get(genderName);
    }

    public GenderProfile getCurrentGender() {
        return this.currentGender;
    }

    public Pronouns getCurrentPronouns() {
        return this.currentPronouns;
    }

    public void setCurrentPronouns(Pronouns pronouns) {
        if(this.pronounsOptions.containsKey(pronouns.getPronounString())) {
            this.currentPronouns = pronouns;
        } else {
            System.out.println(pronouns.getPronounString() + " not in pronoun list for user " + this.getFullName());
        }
    }

    public void addPronouns(Pronouns p) {
        String ps = p.getPronounString();
        this.pronounsOptions.put(ps, p);
        if(this.pronounsOptions.containsValue(p)) {
            this.currentPronouns = p;
            System.out.println("Added Pronouns " + p.getPronounString() + " to user " + this.getFullName());
        } else {
            System.out.println(p.getPronounString() + " was not added to pronoun list for user " + this.getFullName());
        }
    }

    public void removePronouns(String pronounsToRemove) {
        this.pronounsOptions.remove(pronounsToRemove);
    }

    public void setCurrentGender(GenderProfile currentGender) {
        if(genderOptions.containsValue(currentGender)){
            this.currentGender = currentGender;
            this.setCurrentPronouns(currentGender.getDefaultPronouns());
            System.out.println("Gender Set: " + this.currentGender.getGenderName() + " - with Pronouns: " + this.getCurrentPronouns().getPronounString());
        }
    }

    public void setCurrentGender(String newCurrentGender) {
        this.setCurrentGender(getGenderByName(newCurrentGender));
    }

    public void addGender(GenderProfile gender) {
        String gn = gender.getGenderName();
        this.genderOptions.put(gn, gender);
        GenderProfile newGender = getGenderByName(gn);
        this.addPronouns(newGender.getDefaultPronouns());
    }

    public void removeGender(String genderToRemove) {
        String pronoun_key_to_remove = this.genderOptions.remove(genderToRemove).getDefaultPronouns().getPronounString();
        this.removePronouns(pronoun_key_to_remove);
    }

    public Pronouns getPronounsByName(String pronounsKey) {
        return this.pronounsOptions.get(pronounsKey);
    }

    public Collection<GenderProfile> getGenderOptions() {
        return this.genderOptions.values();
    }

    public Collection<Pronouns> getPronounOptions() {
        return this.pronounsOptions.values();
    }

    // Either redundant code or Code that hasn't been completely implemented correctly
    public void setGenderOptions(HashMap<String, GenderProfile> genderOptions) {
        this.genderOptions = genderOptions;
    }

    // Either redundant code or Code that hasn't been completely implemented correctly
    public void setPronounsOptions(HashMap<String, Pronouns> pronounsOptions) {
        this.pronounsOptions = pronounsOptions;
    }
}
