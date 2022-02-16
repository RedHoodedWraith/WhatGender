package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserProfile, String> {

    UserProfile findUserProfileByFullName(String fullName);
    Optional<UserProfile> findByEmail(String email);
    Boolean existsByEmail(String email);
}
