package com.oneaston.oneview.automation.ui.features.security.useraccountmaintenance.model;

import java.util.HashMap;
import java.util.Map;

public class UserAccount {
    private final String code, username;
    private String status, state, role, email;

    public UserAccount(String code, String username, String email, String role, String status, String state) {
        this.code = code;
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = status;
        this.state = state;
    }

    public UserAccount(String code, String username, String status, String state) {
        this.code = code;
        this.username = username;
        this.status = status;
        this.state = state;
    }


    public static Map<String, String> defaultContent() {
        return new HashMap<String, String>() {{
            put("code", "");
            put("username", "");
            put("email", "");
            put("role", "");
            put("status", "");
            put("state", "");
        }};
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }
}
