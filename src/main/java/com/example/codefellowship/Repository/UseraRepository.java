package com.example.codefellowship.Repository;

import com.example.codefellowship.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseraRepository extends JpaRepository<AppUser, Long> {
     AppUser findByUsername(String username);


 //   Ensure that users can’t perform SQL injection or HTML injection with their posts.
 //   Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.
 //   Ensure there is some way (like a users index page) that a user can discover other users on the service.
 //   On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.
 //   note: this will require a self-join on ApplicationUsers.
//    A user can visit a url (like /feed) to view all of the posts from the users that they follow.
//    Each post should have a link to the user profile of the user who wrote the post.

}
