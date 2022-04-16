package com.example.codefellowship.Model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class AppPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    public String body;
    LocalDateTime createdAt;

    @ManyToOne
    AppUser Us;

    public AppPost() {

    }

    public AppPost(String body, LocalDateTime createdAt, AppUser Us) {
        this.body = body;
        this.createdAt = createdAt;
        this.Us = Us;
    }

    public AppPost(String body, LocalDateTime createdAt) {
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


    public AppUser getUs() {
        return Us;
    }

    public void setUs(AppUser us) {
        Us = us;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


