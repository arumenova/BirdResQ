package com.ironhack.birdresq.enums;

public enum Role {

    ADMIN,
    VOLUNTEER;


    public static Role fromString(String role) {
        switch (role.toUpperCase()) {
            case "ADMIN":
                return ADMIN;
            case "VOLUNTEER":
                return VOLUNTEER;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
