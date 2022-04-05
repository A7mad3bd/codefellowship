package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationPost;
import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.PostRepository;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

public class ApplicationPostController {

//    @Autowired
//    PostRepository postRepository;
//
//    @Autowired
//    UseraRepository appUserRepository;
//
//    @PostMapping("/posts")
//    public RedirectView Addpost(Principal p, Model m, String body, String createdAt) {
//        ApplicationUser app = (ApplicationUser) appUserRepository.findByUsername(p.getName());
//
//        if (app != null) {
//            ApplicationPost post = new ApplicationPost(body, createdAt, app);
//            postRepository.save(post);
//        }
//        m.addAttribute("principal", p.getName());
//        m.addAttribute("app", app);
//        return new RedirectView("/myprofile");
//    }
//
//    @GetMapping("/post")
//    public String post() {
//        return "addpost";
//    }
}
