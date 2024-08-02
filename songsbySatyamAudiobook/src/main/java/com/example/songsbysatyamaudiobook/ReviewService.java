package com.example.songsbysatyamaudiobook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public List<Review> getReviewsByAudioBookId(Long audiobookId) {
        return repository.findByAudiobookId(audiobookId);
    }

    public void saveReview(Review review) {
        repository.save(review);
    }
}
