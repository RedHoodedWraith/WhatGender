package com.redhoodedwraith.WhatGender.DataManage;

import java.util.*;

public class Pronouns {
    private final String pronounsString;
    private final LinkedHashSet<String> pronounParts = new LinkedHashSet<>();

    public Pronouns(String... p){
        // Saves Pronouns to List
        int size1 = p.length;
        pronounParts.addAll(Arrays.asList(p).subList(0, size1));

        // Builds All Pronouns as Single String separated by
        Iterator<String> prnIt = pronounParts.iterator();
        int i = 0;
        int size2 = pronounParts.size();
        StringBuilder pronounBuild = new StringBuilder();
        while (prnIt.hasNext()){
            pronounBuild.append(prnIt.next());
            if(i < size2-1)
                pronounBuild.append("/");

            i++;
        }
        pronounsString = pronounBuild.toString();
    }

    public String getPronounString(){
        return pronounsString;
    }

    public Set<String> getPronouns() {
        return Collections.unmodifiableSet(pronounParts);
    }
}
