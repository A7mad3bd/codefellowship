package com.example.codefellowship.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {
    public AppUser() {
    }

    public AppUser(String username, String password, String firstName, String lastName, String dateOfBirth, String specialization, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.specialization = specialization;
        this.bio = bio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String specialization;

    public AppUser(String username, String encode) {

    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPosts(List<AppPost> posts) {
        this.posts = posts;
    }

    public List<AppPost> getPosts() {
        return posts;
    }

    @OneToMany(mappedBy = "Us", cascade = CascadeType.ALL)
    private List<AppPost> posts;


    public List<AppUser> getFollowing() {
        return following;
    }

    public void setFollowing(List<AppUser> following) {
        this.following = following;
    }

    public List<AppUser> getFollower() {
        return follower;
    }

    public void setFollower(List<AppUser> follower) {
        this.follower = follower;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "follow", joinColumns = {@JoinColumn(name = "ing")},
            inverseJoinColumns = {@JoinColumn(name = "er")})
    private List<AppUser> following;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following", fetch = FetchType.EAGER)
    private List<AppUser> follower;


    public String getSpecialization() {
        return specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private String bio;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
