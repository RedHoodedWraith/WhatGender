package com.redhoodedwraith.WhatGender.DataManage;


import java.awt.*;

public class Gender {
    private final String genderName;
    private Pronouns defaultPronouns;
    private final HexColour colour;

    public Gender(String genderName, Pronouns pronouns) {
        this.genderName = genderName;
        setDefaultPronouns(pronouns);
        this.colour = new HexColour();
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
