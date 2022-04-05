package com.example.codefellowship.Model;
import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Entity
public class ApplicationPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String body;
    String createdAt;

    @ManyToOne
    ApplicationUser applicationUser;

    public ApplicationPost(){

    }

    public ApplicationPost(String body, String createdAt, ApplicationUser applicationUser) {
        this.body = body;
        this.createdAt = createdAt;
        this.applicationUser = applicationUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }
}


