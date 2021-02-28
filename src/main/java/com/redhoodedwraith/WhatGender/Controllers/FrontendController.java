package com.redhoodedwraith.WhatGender.Controllers;

import com.redhoodedwraith.WhatGender.DataManage.ProfileData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String showCurrentGender(Model model) {
        model
                .addAttribute("personal_name", ProfileData.getDisplayName())
        .addAttribute("current_gender", ProfileData.getGenderLabel())
        .addAttribute("current_pronouns", ProfileData.getPronouns())
        .addAttribute("backdrop_colour", ProfileData.getColourHex()
        );

        return "index";
    }

}
