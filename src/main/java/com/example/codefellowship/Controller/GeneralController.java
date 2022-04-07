package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class GeneralController {
    @Autowired
    UseraRepository applicationuserRepository;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/")
    public String HomePage() {
        return "home";
    }


    @GetMapping("/myprofile")
    public String userPage(Principal p, Model m) {
        if (p != null) {
            String username = p.getName();
            ApplicationUser newUser = (ApplicationUser) applicationuserRepository.findByUsername(username);
            m.addAttribute("newUser", newUser);
        }
        return "index";
    }

    @GetMapping("/users/{id}")
    public String getuserdata(@PathVariable int id, Model model) {
        ApplicationUser user = applicationuserRepository.findApplicationUserByid(id);
        model.addAttribute("user", user);
        return "userprofile";
    }


}
