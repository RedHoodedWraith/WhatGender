package com.redhoodedwraith.WhatGender.Services;

import com.redhoodedwraith.WhatGender.DataManage.GenderProfile;
import com.redhoodedwraith.WhatGender.DataManage.Pronouns;
import com.redhoodedwraith.WhatGender.DataManage.UserProfile;
import com.redhoodedwraith.WhatGender.DataManage.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.redhoodedwraith.WhatGender.DataManage.DataDefaults.*;

// TODO: Test new implementation
@Component
public class ProfileLoader implements UserDetailsService {

    public static UserRepository repository;
    private static UserProfile currentProfile;

    public ProfileLoader(UserRepository repository) {
        ProfileLoader.repository = repository;
    }

    public static Long addNewUserProfile(UserProfile p) {
        initialiseDefaultGenderOptions(p);
        ProfileLoader.repository.save(p);
        return p.getID();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<UserProfile> p = ProfileLoader.repository.findByEmail(userEmail);

        if(p.isEmpty()){
            throw new UsernameNotFoundException("User not found based on Email: '" + userEmail + "'");
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user"));

        currentProfile = p.get();
        return new User(currentProfile.getEmail(), currentProfile.getPassword(), authorities);
    }

    public static void addGenderOption(GenderProfile gender) {
        currentProfile.addGender(gender);
    }

    public static String getDisplayName() {
        return currentProfile.getNameToDisplay();
    }

    public static void setDisplayName(String newDisplayName) {
        currentProfile.setNameToDisplay(newDisplayName);
    }

    public static String getFullName() {
        return currentProfile.getFullName();
    }

    public static void setFullName(String fullName) {
        currentProfile.setFullName(fullName);
    }

    public static void setCurrentGender(GenderProfile g){
        currentProfile.setCurrentGender(g);
    }

    public static void setCurrentGender(String gkey) {
        currentProfile.setCurrentGender(gkey);
    }

    public static void changeGenderColour(GenderProfile g, String hex) {
        g.setColour(hex);
    }

    public static void changeGenderColour(GenderProfile g, Color col) {
        g.setColour(col);
    }

    public static String getGenderLabel() {
        return currentProfile.getCurrentGender().getGenderName();
    }

    public static String getPreferredName() {
        return currentProfile.getCurrentGender().getPreferredName();
    }

    public static String getPronounsLabel() {
        String pronounStr = currentProfile.getCurrentPronouns().getPronounString();
        System.out.println("Gender Fetched: " + currentProfile.getCurrentGender().getGenderName() + " - Fetched Pronouns: " + pronounStr + " - Fetched Name: " + currentProfile.getCurrentGender().getPreferredName());
        return pronounStr;
    }

    public static String getColourHex() {
        return currentProfile.getCurrentGender().getColourHex();
    }

    public static Collection<GenderProfile> getGenderOptions() {
        return currentProfile.getGenderOptions();
    }

    public static GenderProfile getGenderFromOptions(String genderKey) {
        return currentProfile.getGenderByName(genderKey);
    }

    public static Collection<Pronouns> getPronounOptions() {
        return currentProfile.getPronounOptions();
    }

    public static Pronouns getPronounsFromOptions(String pronounsKey) {
        return currentProfile.getPronounsByName(pronounsKey);
    }

    public static void initialiseDefaultGenderOptions(UserProfile p) {
        if(p == null)
            return;

        if(!p.hasGender(GENDER_UKNOWN))
            p.addGender(new GenderProfile(GENDER_UKNOWN, PRONOUNS_THEY, DEFAULT_UNKNOWN_COLOUR, DEFAULT_NAME));

        if(!p.hasGender(NON_BINARY))
            p.addGender(new GenderProfile(NON_BINARY, PRONOUNS_THEY, DEFAULT_NON_BINARY_COLOUR, DEFAULT_NAME));

        if(!p.hasGender(MALE))
            p.addGender(new GenderProfile(MALE, PRONOUNS_HE, DEFAULT_MALE_COLOUR, DEFAULT_NAME));

        if(!p.hasGender(FEMALE))
            p.addGender(new GenderProfile(FEMALE, PRONOUNS_SHE, DEFAULT_FEMALE_COLOUR, DEFAULT_NAME));

        p.setCurrentGender(GENDER_UKNOWN);
    }

    public static void printUserSummary() {
        System.out.println(currentProfile);
    }

}
