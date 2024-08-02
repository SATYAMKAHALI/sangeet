package com.example.songsbysatyamaudiobook;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class AudioBook {

    @Id
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String coverImage;
    private String description;
    private double rating;

    @OneToMany(mappedBy = "audiobookId")
    private List<Review> reviews;

    // Two Constructors ... Constructor overloading
    public AudioBook(){

    }
    public AudioBook(Long id, String title, String author, String genre, String coverImage, String description, double rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.coverImage = coverImage;
        this.description = description;
        this.rating = rating;
    }

    public AudioBook(String title, String author, String genre, String coverImage, String description, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.coverImage = coverImage;
        this.description = description;
        this.rating = rating;
    }

    // getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
