package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class GeneralController {
    @Autowired
    UseraRepository appUseraRepository;

    @GetMapping("/")
    public String homePage(){
            return "home";
    }
    @GetMapping("/user")
    public String indexPage(Principal p, Model model) {
        if (p != null) {
            ApplicationUser userdata = appUseraRepository.findApplicationUserByUsername(p.getName());
            model.addAttribute("userdata", userdata);
            return "user";
        } else {
            return "login";
        }
    }
//
//    }
//    @GetMapping("/user")
//    public String getUserprofile(Principal p, Model m){
//        try {
//            ApplicationUser userdata = appUserRepository.findUserByUserName(p.getName());
//            m.addAttribute("userdata", userdata);
//        } catch(Exception e){
//            System.out.println(e);
//        }
//        return "user";
//    }
//
//    @GetMapping("/user/{id}")
//    public String getUser(@PathVariable long id, Model m){
//        ApplicationUser userdata = appUserRepository.findUserById(id);
//        m.addAttribute("userdata", userdata);
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return "user";
//    }
//
//
//    @GetMapping("/user/{id}")
//    public String getUserProfile(@PathVariable Long id, Model model){
//        ApplicationUser userdata = appUserRepository.findUserById(id);
//        model.addAttribute("userdata", userdata);
//        return "user";
//    }
}
