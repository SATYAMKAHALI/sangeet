package com.example.songsbysatyamaudiobook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/audiobooks")
public class AudioBookController {

    @Autowired
    private AudioBookService audioBookService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("")
    public String getAllAudioBooks(@RequestParam(required = false) String sort, Model model) {
        List<AudioBook> audiobooks = audioBookService.getAllAudioBooks();
        if ("rating".equals(sort)) {
            audiobooks.sort((a1, a2) -> Double.compare(a2.getRating(), a1.getRating()));
        }
        model.addAttribute("audiobooks", audiobooks);
        return "audiobook-list";
    }

    @GetMapping("/{id}")
    public String getAudioBookById(@PathVariable Long id, Model model) {
        AudioBook audiobook = audioBookService.getAudiobookById(id);
        model.addAttribute("audiobook", audiobook);
        model.addAttribute("reviews", reviewService.getReviewsByAudioBookId(id));
        return "audiobook-detail";
    }

    @PostMapping("/review")
    public String submitReview(@RequestParam Long id, @RequestParam String username,
                               @RequestParam String comment, @RequestParam int rating) {
        Review review = new Review();
        review.setAudiobookId(id);
        review.setUsername(username);
        review.setComment(comment);
        review.setRating(rating);
        reviewService.saveReview(review);
        return "redirect:/audiobooks/" + id;
    }
}
