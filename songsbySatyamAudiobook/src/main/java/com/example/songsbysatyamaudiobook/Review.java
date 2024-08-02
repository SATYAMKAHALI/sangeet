package com.example.songsbysatyamaudiobook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long audiobookId;
    private String username;
    private String comment;
    private int rating;

    //constructors

    public Review() {

    }

    public Review(Long audiobookId, String username, String comment, int rating) {
        this.audiobookId = audiobookId;
        this.username = username;
        this.comment = comment;
        this.rating = rating;
    }


    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAudiobookId() {
        return audiobookId;
    }

    public void setAudiobookId(Long audiobookId) {
        this.audiobookId = audiobookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
