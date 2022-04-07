package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationPost;
import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Repository.PostRepository;
import com.example.codefellowship.Repository.UseraRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        ApplicationUser user = (ApplicationUser) appUserRepository.findByUsername(p.getName());
        LocalDateTime createdAt = LocalDateTime.now();
        ApplicationPost post = new ApplicationPost(body, createdAt, user);
        postRepository.save(post);
        List<ApplicationPost> list = user.getPosts();
        return new RedirectView("/posts");
    }

    @GetMapping("/post")
    public String postpage() {
        return "post";
    }

    @GetMapping("/posts")
    public String postspage(Model m) {
        List a;
        a = postRepository.findAll();
        m.addAttribute("posts", a);
        return "posts";
    }


}
