package com.example.codefellowship.Repository;

import com.example.codefellowship.Model.AppPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<AppPost, Long> {
    public AppPost findById(long id);
    public AppPost findApplicationPostsById(int id);
    public AppPost findApplicationPostById(int id);
}
