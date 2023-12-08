package com.musicapp.model;

public enum Gender {
    MALE, FEMALE;

    public String getGenderName(Gender gender) {
        switch (gender) {
            case MALE: return "Man";
            case FEMALE: return "Woman";
            default: return null;
        }
    }
}
