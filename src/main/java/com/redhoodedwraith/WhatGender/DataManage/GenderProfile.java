package com.redhoodedwraith.WhatGender.DataManage;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.awt.*;

public class GenderProfile {

    @Id
    public Long id;
    private final String genderName;
    private String preferredName;
    private Pronouns defaultPronouns;
    private final HexColour colour;

    @PersistenceConstructor
    public GenderProfile(String genderName, Pronouns defaultPronouns, HexColour colour, String preferredName) {
        this.genderName = genderName;
        setDefaultPronouns(defaultPronouns);
        this.colour = colour;
        this.preferredName = preferredName;
    }

    public GenderProfile(String genderName, Pronouns pronouns, String preferredName) {
        this(genderName, pronouns, new HexColour(), preferredName);
    }

    public GenderProfile(String genderName, Pronouns pronouns, String hexColourCode, String preferredName) {
        this(genderName, pronouns, new HexColour(hexColourCode), preferredName);
    }

    public String getGenderName() {
        return genderName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
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
