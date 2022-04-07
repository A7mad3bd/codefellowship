package com.example.codefellowship.Model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class ApplicationPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String body;
    LocalDateTime createdAt;

    @ManyToOne
    ApplicationUser Us;

    public ApplicationPost() {

    }

    public ApplicationPost(String body, LocalDateTime createdAt, ApplicationUser Us) {
        this.body = body;
        this.createdAt = createdAt;
        this.Us = Us;
    }

    public ApplicationPost(String body, LocalDateTime createdAt) {
        this.body = body;
        this.createdAt = createdAt;
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


    public ApplicationUser getUs() {
        return Us;
    }

    public void setUs(ApplicationUser us) {
        Us = us;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


