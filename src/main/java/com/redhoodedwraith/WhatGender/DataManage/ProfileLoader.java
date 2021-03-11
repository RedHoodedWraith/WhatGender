package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProfileLoader {

    public static UserRepository repository;
    private static UserProfile currentProfile;

    public ProfileLoader(UserRepository repository) {
        ProfileLoader.repository = repository;
    }

    public static Long addNewUserProfile(UserProfile p) {
        ProfileLoader.repository.save(p);
        return p.getID();
    }

    public static boolean loadUserProfile(Long userID) {
        Optional<UserProfile> p = ProfileLoader.repository.findById(userID);

        if(p.isEmpty()){
            return false;
        }

        currentProfile = p.get();
        return true;
    }

    public static void addGenderOption(Gender gender) {
        currentProfile.addGender(gender);
    }

    public static String getDisplayName() {
        return currentProfile.getNameToDisplay();
    }

    public static void setDisplayName(String newDisplayName) {
        currentProfile.setNameToDisplay(newDisplayName);
    }

    public static String getFullName() {
        return currentProfile.getFullName();
    }

    public static void setFullName(String fullName) {
        currentProfile.setFullName(fullName);
    }

    public static void setCurrentGender(Gender g){
        currentProfile.setCurrentGender(g);
    }

    public static void setCurrentGender(String gkey) {
        currentProfile.setCurrentGender(gkey);
    }

    public static void changeGenderColour(Gender g, String hex) {
        g.setColour(hex);
    }

    public static void changeGenderColour(Gender g, Color col) {
        g.setColour(col);
    }

    public static String getGenderLabel() {
        return currentProfile.getCurrentGender().getGenderName();
    }

    public static String getPronounsLabel() {
        return currentProfile.getCurrentPronouns().getPronounString();
    }

    public static String getColourHex() {
        return currentProfile.getCurrentGender().getColourHex();
    }

    public static Collection<Gender> getGenderOptions() {
        return currentProfile.getGenderOptions();
    }

    public static Gender getGenderFromOptions(String genderKey) {
        return currentProfile.getGenderByName(genderKey);
    }

    public static Collection<Pronouns> getPronounOptions() {
        return currentProfile.getPronounOptions();
    }

    public static Pronouns getPronounsFromOptions(String pronounsKey) {
        return currentProfile.getPronounsByName(pronounsKey);
    }

}
