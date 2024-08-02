package com.example.songsbysatyamaudiobook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioBookRepository extends JpaRepository<AudioBook, Long> {
}
