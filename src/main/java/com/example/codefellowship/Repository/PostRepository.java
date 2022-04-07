package com.example.codefellowship.Repository;

import com.example.codefellowship.Model.ApplicationPost;
import com.example.codefellowship.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<ApplicationPost, Long> {
    public ApplicationPost findApplicationPostById(int id);
    public ApplicationPost findById(long id);
    public ApplicationPost findApplicationPostsById(int id);
}
