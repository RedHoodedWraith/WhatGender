package com.redhoodedwraith.WhatGender.DataManage;

public class UpdateSubmission {
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Gender convertToGender(){
        if(gender == null || gender.equals(""))
            throw new NullPointerException("Gender Key is Null");

        Gender g = ProfileLoader.getGenderFromOptions(gender);
        if(g == null)
            throw new NullPointerException("Gender Object is Null. Tried fetching: " + gender);
        return g;
    }

}
