package com.redhoodedwraith.WhatGender.Controllers;

import com.redhoodedwraith.WhatGender.DataManage.ProfileData;
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
        model.addAttribute("personal_name", ProfileData.getDisplayName())
                .addAttribute("current_gender", ProfileData.getGenderLabel())
                .addAttribute("gender_opts", ProfileData.getGenderOptions())
        .addAttribute("sub", new UpdateSubmission());
        return "update";
    }

    @PostMapping("/update")
    public String submitUpdatedGender(@ModelAttribute UpdateSubmission sub, Model model) {
        if(sub == null){
            throw new NullPointerException("Submission is Empty");
        }

        model.addAttribute("sub", sub);

        System.out.println("Gender Received: " + sub.getGender());

        ProfileData.setCurrentGender(sub.convertToGender());

        return "update_success";
    }

}
