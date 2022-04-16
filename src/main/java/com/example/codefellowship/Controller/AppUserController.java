package com.example.codefellowship.Controller;


import com.example.codefellowship.Model.AppUser;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppUserController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UseraRepository appUseraRepository;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupUser(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String dateOfBirth, @RequestParam String specialization, @RequestParam String bio) {
        AppUser appuser = new AppUser(username, encoder.encode(password), firstName, lastName, dateOfBirth, specialization, bio);
        appUseraRepository.save(appuser);
        return "login";
    }

}

