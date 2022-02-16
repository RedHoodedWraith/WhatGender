package com.redhoodedwraith.WhatGender.Controllers;

import com.redhoodedwraith.WhatGender.Services.ProfileLoader;
import com.redhoodedwraith.WhatGender.DataManage.UpdateSubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BackendController {

    @GetMapping("/update")
    public String updateGender(Model model) {
        model.addAttribute("personal_name", ProfileLoader.getDisplayName())
                .addAttribute("current_gender", ProfileLoader.getGenderLabel())
                .addAttribute("gender_opts", ProfileLoader.getGenderOptions())
        .addAttribute("sub", new UpdateSubmission());
        return "update";
    }

    @PostMapping("/update")
    public String submitUpdatedGender(@ModelAttribute UpdateSubmission sub, Model model) {
        if(sub == null){
            throw new NullPointerException("Submission is Empty");
        }

        model.addAttribute("sub", sub);

//        System.out.println("Gender Received: " + sub.getGender() + " - with Pronouns: " + sub.getPronouns());

        ProfileLoader.setCurrentGender(sub.convertToGender());

        return "update_success";
    }

}
