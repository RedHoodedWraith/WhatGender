package com.redhoodedwraith.WhatGender;

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
//        System.out.println("\nDeleting Repository...\n");
//        ProfileLoader.repository.deleteAll();
//        System.out.println("\nAdding First User...\n");
//        Long id = ProfileLoader.addNewUserProfile(new UserProfile("Red Hooded Wraith"));
//        ProfileLoader.loadUserProfile(id);
//        ProfileLoader.printUserSummary();
    }
}
