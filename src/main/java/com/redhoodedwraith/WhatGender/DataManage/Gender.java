package com.redhoodedwraith.WhatGender.DataManage;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.awt.*;

public class Gender {

    @Id
    public Long id;
    private final String genderName;
    private Pronouns defaultPronouns;
    private final HexColour colour;

    @PersistenceConstructor
    public Gender(String genderName, Pronouns defaultPronouns, HexColour colour) {
        this.genderName = genderName;
        setDefaultPronouns(defaultPronouns);
        this.colour = colour;
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
