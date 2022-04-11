package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.AppPost;
import com.example.codefellowship.Model.AppUser;
import com.example.codefellowship.Repository.PostRepository;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ApplicationPostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UseraRepository appUserRepository;

    @PostMapping("/post")
    public RedirectView addpost(Principal p, Model m, String body) {
        AppUser user = (AppUser) appUserRepository.findByUsername(p.getName());
        LocalDateTime createdAt = LocalDateTime.now();
        AppPost post = new AppPost(body, createdAt, user);
        postRepository.save(post);
        List<AppPost> list = user.getPosts();
        return new RedirectView("/posts");


    }

    @GetMapping("/post")
    public String postpage(Model m, Principal p) {
        return "post";
    }

    @GetMapping("/posts")
    public String postspage(Model m, Authentication auth) {
        List a;
        a = postRepository.findAll();
        m.addAttribute("user1",auth.getPrincipal());
        m.addAttribute("posts", a);
        return "posts";
    }


}
