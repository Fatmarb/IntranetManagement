package com.IntranetManagement.IntranetManagement.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }
}
