package com.redhoodedwraith.WhatGender.DataManage;

import com.redhoodedwraith.WhatGender.Services.ProfileLoader;

public class UpdateSubmission {
    private String gender;

    public String getGender() {
        return gender;
    }

    public String getPronouns() {
        return convertToGender().getDefaultPronouns().getPronounString();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public GenderProfile convertToGender(){
        if(gender == null || gender.equals(""))
            throw new NullPointerException("GenderProfile Key is Null");

        GenderProfile g = ProfileLoader.getGenderFromOptions(gender);
        if(g == null)
            throw new NullPointerException("GenderProfile Object is Null. Tried fetching: " + gender);
        return g;
    }

}
