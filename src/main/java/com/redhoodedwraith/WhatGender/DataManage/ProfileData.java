package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

@Service
public class ProfileData {

    public static String
            MALE="Male",
        FEMALE="Female",
        NON_BINARY="Non-Binary";

    private static String displayName;
    private static Gender currentGender;

    private static final HashMap<String, Gender> genderOptions = new HashMap<>();

    public static void initialiseDefaultGenderOptions() {
        addGenderOption(new Gender(NON_BINARY, new Pronouns("They", "Them", "Their")));
        addGenderOption(new Gender(MALE, new Pronouns("He", "Him", "His")));
        addGenderOption(new Gender(FEMALE, new Pronouns("She", "Her", "Hers")));

        setGenderColour(genderOptions.get(MALE), "#020122");
        setGenderColour(genderOptions.get(NON_BINARY), "#067575");
        setGenderColour(genderOptions.get(FEMALE), "#db1a4d");
    }

    public static void addGenderOption(Gender gender) {
        genderOptions.put(gender.getGenderName(), gender);
    }

    public static String getDisplayName() {
        return displayName;
    }

    public static void setDisplayName(String newDisplayName) {
        displayName = newDisplayName;
    }

    public static void setCurrentGender(Gender g){
        currentGender = g;
    }

    public static void setCurrentGender(String gkey) {
        Gender g = genderOptions.get(gkey);
        if(g == null){
            throw new NullPointerException("Gender Key Not Found");
        }
        setCurrentGender(g);
    }

    public static void setGenderColour(Gender g, String hex) {
        g.setColour(hex);
    }

    public static void setGenderColour(Gender g, Color col) {
        g.setColour(col);
    }

    public static String getGenderLabel() {
        return currentGender.getGenderName();
    }

    public static String getPronouns() {
        return currentGender.getDefaultPronouns().getPronounString();
    }

    public static String getColourHex() {
        return currentGender.getColourHex();
    }

    public static Collection<Gender> getGenderOptions() {
        return genderOptions.values();
    }

    public static Gender getGenderFromOptions(String gender) {
        return genderOptions.get(gender);
    }
}
