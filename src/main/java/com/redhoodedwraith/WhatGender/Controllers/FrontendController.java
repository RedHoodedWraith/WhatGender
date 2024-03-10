package com.redhoodedwraith.WhatGender.Controllers;

import com.redhoodedwraith.WhatGender.DataManage.UserProfile;
import com.redhoodedwraith.WhatGender.DataManage.UserProfileDTO;
import com.redhoodedwraith.WhatGender.Services.Exceptions.UserAlreadyExistException;
import com.redhoodedwraith.WhatGender.Services.ProfileLoader;
import com.redhoodedwraith.WhatGender.Services.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String showCurrentGender(Model model) {
        model
                .addAttribute("personal_name", ProfileLoader.getDisplayName())
                .addAttribute("current_gender", ProfileLoader.getGenderLabel())
                .addAttribute("current_pronouns", ProfileLoader.getPronounsLabel())
                .addAttribute("backdrop_colour", ProfileLoader.getColourHex()
        );

        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(WebRequest request, Model model) {
        UserProfileDTO profile = new UserProfileDTO();
        model.addAttribute("user", profile);

        return "signup";
    }

    @PostMapping("/signup")
    public ModelAndView signUpUser(
            @ModelAttribute("user") @Valid UserProfileDTO userDto,
            HttpServletRequest request,
            Errors errors) {

        try {
            ProfileService profileService = new ProfileService();
            UserProfile registered = profileService.registerNewProfile(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView("signup");
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }

        return new ModelAndView("update_success", "user", userDto);
    }

}
