package com.redhoodedwraith.WhatGender.DataManage;


import java.awt.*;

public class Gender {

    public static String
            MALE="Male",
            FEMALE="Female",
            NON_BINARY="Non-Binary";

    public static String
            DEFAULT_MALE_COLOUR = "#020122",
            DEFAULT_FEMALE_COLOUR = "#db1a4d",
            DEFAULT_NON_BINARY_COLOUR = "#067575";


    private final String genderName;
    private Pronouns defaultPronouns;
    private final HexColour colour;

    public Gender(String genderName, Pronouns pronouns, HexColour hexColour) {
        this.genderName = genderName;
        setDefaultPronouns(pronouns);
        this.colour = hexColour;
    }

    public Gender(String genderName, Pronouns pronouns) {
        this(genderName, pronouns, new HexColour());
    }

    public Gender(String genderName, Pronouns pronouns, String hexColourCode) {
        this(genderName, pronouns, new HexColour(hexColourCode));
    }

    public String getGenderName() {
        return genderName;
    }

    public Pronouns getDefaultPronouns() {
        return defaultPronouns;
    }

    public void setDefaultPronouns(Pronouns defaultPronouns) {
        this.defaultPronouns = defaultPronouns;
    }

    public HexColour getColourHexObj() {
        return colour;
    }

    public Color getJavaColorObj() {
        return this.colour.getJavaColor();
    }

    public void setColour(Color colour) {
        this.colour.setColour(colour);
    }

    public void setColour(String hexCode) {
        colour.setColour(hexCode);
    }

    public String getColourHex() {
        return colour.getHexColourCode();
    }
}
