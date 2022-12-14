package com.example.music.repository;

import com.example.music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {

    Music findById(int id);

}
