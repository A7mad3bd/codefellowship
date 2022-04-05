package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class GeneralController {
    @Autowired
    UseraRepository applicationuserRepository;

    @Autowired
    PasswordEncoder encoder;
    @GetMapping("/user")
    public String userPage(Principal p, Model m){
        if (p != null){
            String username = p.getName();
            ApplicationUser newUser = (ApplicationUser) applicationuserRepository.findByUsername(username);
            m.addAttribute("newUser", newUser);
        }
        return "index";
    }

    @GetMapping("/")
    public String HomePage(){
        return "home";
    }
}
