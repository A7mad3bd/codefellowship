package com.example.codefellowship.Repository;

import com.example.codefellowship.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
@Repository
public interface UseraRepository extends JpaRepository<ApplicationUser, Long> {
    public UserDetails findByUsername(String username);
    public ApplicationUser findById(long id);
    public ApplicationUser findApplicationUserByid(int id);
}
