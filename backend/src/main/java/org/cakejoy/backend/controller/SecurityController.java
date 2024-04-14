package org.cakejoy.backend.controller;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@NoArgsConstructor
public class SecurityController {

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signUp")
    public String register() {
        return "register";
    }

}
