package com.redhoodedwraith.WhatGender;

import com.redhoodedwraith.WhatGender.DataManage.ProfileData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {
    public static void main(String... args){
        ProfileData.setDisplayName("Rowan Rathod");
        ProfileData.initialiseDefaultGenderOptions();
        ProfileData.setCurrentGender(ProfileData.MALE);
        SpringApplication.run(Runner.class, args);
    }
}
