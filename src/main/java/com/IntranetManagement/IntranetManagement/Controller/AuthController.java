package com.IntranetManagement.IntranetManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }
    @GetMapping("/login-success")
    public String loginSuccessPage() {
        return "LoginSuccess"; // LoginSuccess.html in Thymeleaf
    }
}
