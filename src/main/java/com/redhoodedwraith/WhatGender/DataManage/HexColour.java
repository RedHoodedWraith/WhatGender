package com.redhoodedwraith.WhatGender.DataManage;

import java.awt.*;

public class HexColour {

    public static final Color DEFAULT_NOT_YET_CHOSEN_COLOUR = Color.DARK_GRAY;
    private String hexColourCode;

    public HexColour(String hex) {
        this.setColour(hex);
    }

    public HexColour(Color colour) {
        setColour(colour);
    }

    public HexColour() {
        this(DEFAULT_NOT_YET_CHOSEN_COLOUR);
    }

    public void setColour(Color colour) {
        this.hexColourCode = String.format("#%02X%02X%02X",
                colour.getRed(),
                colour.getGreen(),
                colour.getBlue()
        );
    }

    public void setColour(String hexCode) {
        this.hexColourCode = hexCode;
    }

    public String getHexColourCode() {
        return this.hexColourCode;
    }

    public Color getJavaColor() {
        return convertToJavaColor(this);
    }

    public static Color convertToJavaColor(HexColour hexColour){
        return Color.decode(hexColour.getHexColourCode());
    }
}
