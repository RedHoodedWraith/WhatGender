package com.redhoodedwraith.WhatGender.DataManage;

import java.awt.*;

public class Gender {
    private final String genderName;
    private Pronouns defaultPronouns;
    private Color colour;

    public Gender(String genderName, Pronouns pronouns) {
        this.genderName = genderName;
        setDefaultPronouns(pronouns);
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

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setColour(String hexCode) {
        colour = Color.decode(hexCode);
    }

    public String getColourHex() {
        return String.format("#%02X%02X%02X",
                colour.getRed(),
                colour.getGreen(),
                colour.getBlue()
        );
    }
}
