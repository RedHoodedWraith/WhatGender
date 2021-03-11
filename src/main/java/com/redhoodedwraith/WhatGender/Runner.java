package com.redhoodedwraith.WhatGender;

import com.redhoodedwraith.WhatGender.DataManage.ProfileLoader;
import com.redhoodedwraith.WhatGender.DataManage.UserProfile;
import com.redhoodedwraith.WhatGender.DataManage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    public static void main(String... args){
        SpringApplication.run(Runner.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ProfileLoader.setDisplayName("Rowan Rathod");
        ProfileLoader.initialiseDefaultGenderOptions();
        ProfileLoader.setCurrentGender(ProfileLoader.MALE);
    }
}
