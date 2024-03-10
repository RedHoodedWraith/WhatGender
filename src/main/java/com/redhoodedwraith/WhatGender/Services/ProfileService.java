package com.redhoodedwraith.WhatGender.Services;

import com.redhoodedwraith.WhatGender.DataManage.UserProfile;
import com.redhoodedwraith.WhatGender.DataManage.UserProfileDTO;
import com.redhoodedwraith.WhatGender.DataManage.UserRepository;
import com.redhoodedwraith.WhatGender.Services.Exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ProfileService implements ProfileServiceInterface {

    @Autowired
    private UserRepository repository;

    @Override
    public UserProfile registerNewProfile(UserProfileDTO profileDTO) throws UserAlreadyExistException {
        if(emailExists(profileDTO.getEmail())) {
            throw new UserAlreadyExistException("User with email: '" + profileDTO.getEmail() + "' already exists");
        }

        UserProfile profile = new UserProfile(profileDTO.getEmail(), profileDTO.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));

        return repository.save(profile);
    }

    private boolean emailExists(String email) {
        return repository.findByEmail(email).isPresent();
    }

}
