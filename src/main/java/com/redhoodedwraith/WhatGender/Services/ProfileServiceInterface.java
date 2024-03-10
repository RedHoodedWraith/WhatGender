package com.redhoodedwraith.WhatGender.Services;

import com.redhoodedwraith.WhatGender.DataManage.UserProfile;
import com.redhoodedwraith.WhatGender.DataManage.UserProfileDTO;
import com.redhoodedwraith.WhatGender.Services.Exceptions.UserAlreadyExistException;

public interface ProfileServiceInterface {

    public UserProfile registerNewProfile(UserProfileDTO profileDTO) throws UserAlreadyExistException;

}
