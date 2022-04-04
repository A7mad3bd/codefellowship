package com.example.codefellowship.Model;
import javax.persistence.*;
import java.util.Date;

@Entity
public class ApplicationPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    String body;
    Date createdAt;

    @ManyToOne
    ApplicationUser applicationUser;

    public ApplicationPost(){

    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser postByUser) {
        this.applicationUser = postByUser;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ApplicationPost(String title, String body) {
        this.title = title;
        this.body = body;
    }


}


