package com.example.music.service.impl;

import com.example.music.model.Music;
import com.example.music.repository.IMusicRepository;
import com.example.music.service.IMusicServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicServer {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public void addNewSong(Music music) {
        musicRepository.save(music);
    }

    @Override
    public List<Music> musicList() {
        return musicRepository.findAll();
    }

    @Override
    public void editMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music songId(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void deleteMusic(int id) {
        musicRepository.deleteById(id);
    }
}
