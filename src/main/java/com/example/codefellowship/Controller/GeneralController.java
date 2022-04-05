package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationPost;
import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.PostRepository;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
//
//    @GetMapping("/users/{id}")
//    public String userprofileid(@PathVariable String id,Principal p,Model m) {
//        long ID = Long.parseLong(id);
//        ApplicationUser user = applicationuserRepository.findById(ID);
//        m.addAttribute("user", user);
//        return "userprofile";
//    }


}
