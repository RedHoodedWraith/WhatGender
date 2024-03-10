package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashMap;

@Document(collection = "users")
public class UserProfile extends User {

    @Id
    public long id;
    @Email
    @NotBlank
    private String email;
    private String fullName;
    private String nameToDisplay;
    private GenderProfile currentGender;
    private Pronouns currentPronouns;
    private HashMap<String, GenderProfile> genderOptions = new HashMap<>();
    private HashMap<String, Pronouns> pronounsOptions = new HashMap<>();

    public UserProfile(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
    }



    @Override
    public String toString() {
        return String.format("User[id='%s', fullName='%s', pronouns='%s', genders='%s']",
                id, fullName, pronounsOptions.keySet(), genderOptions.keySet());
    }

    public Long getID() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
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
