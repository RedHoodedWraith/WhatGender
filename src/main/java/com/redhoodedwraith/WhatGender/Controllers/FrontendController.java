package com.redhoodedwraith.WhatGender.Controllers;

import com.redhoodedwraith.WhatGender.DataManage.ProfileLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
