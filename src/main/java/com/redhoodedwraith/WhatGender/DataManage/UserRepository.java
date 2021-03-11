package com.redhoodedwraith.WhatGender.DataManage;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserProfile, Long> {

    UserProfile findUserProfileByFullName(String fullName);
    List<UserProfile> findByPreferredName(String preferredName);
    @Override
    Optional<UserProfile> findById(Long aLong);
}
