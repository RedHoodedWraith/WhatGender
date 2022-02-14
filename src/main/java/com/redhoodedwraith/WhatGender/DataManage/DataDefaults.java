package com.redhoodedwraith.WhatGender.DataManage;

public interface DataDefaults {
    String
            GENDER_UKNOWN="Unknown Gender",
            MALE="Male",
            FEMALE="Female",
            NON_BINARY="Non-Binary";

    String
            DEFAULT_UNKNOWN_COLOUR = "#21003A",
            DEFAULT_MALE_COLOUR = "#020122",
            DEFAULT_FEMALE_COLOUR = "#db1a4d",
            DEFAULT_NON_BINARY_COLOUR = "#067575";

    String
            DEFAULT_NAME = "Unknown Name!";

    Pronouns
            PRONOUNS_THEY = new Pronouns("They", "Them", "Their"),
            PRONOUNS_HE = new Pronouns("He", "Him", "His"),
            PRONOUNS_SHE = new Pronouns("She", "Her", "Hers");

}
