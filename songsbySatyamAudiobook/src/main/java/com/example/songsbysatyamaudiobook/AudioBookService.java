package com.example.songsbysatyamaudiobook;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AudioBookService {

    @Autowired
    private AudioBookRepository repository;

    public List<AudioBook> getAllAudioBooks() {
        return repository.findAll();
    }

    public AudioBook getAudiobookById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void saveAudioBook(AudioBook audiobook) {
        repository.save(audiobook);
    }

    @PostConstruct
    public void initData() {
        try {
            List<AudioBook> audiobooks = List.of(
                    new AudioBook(1L, " Summertime Sadness ", " Lana Del Rey ", "    Trip hop ", "https://upload.wikimedia.org/wikipedia/en/thumb/2/22/SummertimeSadnessOfficial.png/220px-SummertimeSadnessOfficial.png", "A melancholic pop song",   4.5),
                    new AudioBook(2L, " Cheques ", " Shubh ", "Indian Hip-Hop ", "https://i1.sndcdn.com/artworks-fgQCI3pFN0to-0-t500x500.jpg", "A rap song about success",   4.0),
                    new AudioBook(3L, " Waka Waka ", " Shakira ", " Soca music ", "https://images.indianexpress.com/2016/01/shakira-wakawaka759.jpeg", "Official 2010 FIFA World Cup song",   4.8),
                    new AudioBook(4L, " Blinding Lights ", " The Weeknd ", " Synthwave ", "https://upload.wikimedia.org/wikipedia/en/e/e6/The_Weeknd_-_Blinding_Lights.png", "A synthwave song",   4.9)
            );
            repository.saveAll(audiobooks);
        } catch (Exception e) {
            // Log the error for debugging
            e.printStackTrace();
            throw new RuntimeException("Error initializing audio books", e);
        }
    }
}



