package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.HashMap;

import static com.redhoodedwraith.WhatGender.DataManage.Gender.*;
import static com.redhoodedwraith.WhatGender.DataManage.Pronouns.*;

public class UserProfile {

    @Id
    public long id;
    private String fullName;
    private String nameToDisplay;
    private String preferredName;
    private Gender currentGender;
    private Pronouns currentPronouns;
    private final HashMap<String, Gender> genderOptions = new HashMap<>();
    private final HashMap<String, Pronouns> pronounsOptions = new HashMap<>();

    public UserProfile() {
        this.initialiseDefaultGenderOptions();
    }

    public UserProfile(String fullName, String preferredName) {
        this();
        this.fullName = fullName;
        this.preferredName = preferredName;
        this.nameToDisplay = this.preferredName;
    }

    @Override
    public String toString() {
        return String.format("User[id='%s', preferredName='%s']", id, preferredName);
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

    public Gender getCurrentGender() {
        return this.currentGender;
    }

    public Pronouns getCurrentPronouns() {
        return this.currentPronouns;
    }

    public void setCurrentPronouns(Pronouns pronouns) {
        if(this.pronounsOptions.containsValue(pronouns)) {
            this.currentPronouns = pronouns;
        }
    }

    public void addPronouns(Pronouns p) {
        this.pronounsOptions.put(p.getPronounString(), p);
    }

    public void removePronouns(String pronounsToRemove) {
        this.pronounsOptions.remove(pronounsToRemove);
    }

    public void setCurrentGender(String newCurrentGender) {
        this.setCurrentGender(getGenderByName(newCurrentGender));
    }

    public void setCurrentGender(Gender currentGender) {
        if(genderOptions.containsValue(currentGender)){
            this.currentGender = currentGender;
            this.setCurrentPronouns(currentGender.getDefaultPronouns());
        }
    }

    public void addGender(Gender gender) {
        this.genderOptions.put(gender.getGenderName(), gender);
        this.addPronouns(gender.getDefaultPronouns());
    }

    public void removeGender(String genderToRemove) {
        String pronoun_key_to_remove = this.genderOptions.remove(genderToRemove).getDefaultPronouns().getPronounString();
        this.removePronouns(pronoun_key_to_remove);
    }

    public boolean hasGender(String genderName) {
        return this.genderOptions.containsKey(genderName);
    }

    public Gender getGenderByName(String genderName) {
        return this.genderOptions.get(genderName);
    }

    public Pronouns getPronounsByName(String pronounsKey) {
        return this.pronounsOptions.get(pronounsKey);
    }

    public Collection<Gender> getGenderOptions() {
        return this.genderOptions.values();
    }

    public Collection<Pronouns> getPronounOptions() {
        return this.pronounsOptions.values();
    }

    public void initialiseDefaultGenderOptions() {
        if(!this.hasGender(NON_BINARY))
            this.addGender(new Gender(NON_BINARY, PRONOUNS_THEY, DEFAULT_NON_BINARY_COLOUR));

        if(!this.hasGender(MALE))
            this.addGender(new Gender(MALE, PRONOUNS_HE, DEFAULT_MALE_COLOUR));

        if(!this.hasGender(FEMALE))
            this.addGender(new Gender(FEMALE, PRONOUNS_SHE, DEFAULT_FEMALE_COLOUR));
    }

}
