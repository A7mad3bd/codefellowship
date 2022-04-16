package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.AppUser;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class GeneralController {
    @Autowired
    UseraRepository appuserRepository;

    @Autowired
    PasswordEncoder encoder;


    @GetMapping("/")
    public String HomePage() {
        return "home";
    }


    @GetMapping("/discover")
    public String discover(Model m, Authentication auth) {
        m.addAttribute("users", appuserRepository.findAll());
        m.addAttribute("user1", auth.getPrincipal());
        return "discover";
    }

    @GetMapping("/feed")

    public String feed(Model m, Principal p) {
        String username = p.getName();
        AppUser User = (AppUser) appuserRepository.findByUsername(username);
        m.addAttribute("user", User);
        return "feed";
    }


    @GetMapping("/myprofile")
    public String userPage(Principal p, Model m) {
        if (p != null) {
            String username = p.getName();
            AppUser newUser = (AppUser) appuserRepository.findByUsername(username);
            m.addAttribute("newUser", newUser);
        }
        return "index";
    }

    @GetMapping("/users/{id}")
    public String getuserdata(@PathVariable Long id, Model model) {
        AppUser user = appuserRepository.getById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userprofile";
        } else
            return "home";

    }

    @Transactional
    @GetMapping("/follow/{folid}/{invfolid}")
    String follow(@PathVariable Long folid, @PathVariable Long invfolid, Model model) {
        AppUser fol = appuserRepository.getById(folid);
        AppUser invfol = appuserRepository.getById(invfolid);
        if (folid != invfolid) {
            fol.getFollowing().add(invfol);
            invfol.getFollower().add(fol);
            appuserRepository.save(fol);
            appuserRepository.save(invfol);
        }
        return "redirect:/posts";
    }


}
