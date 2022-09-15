package com.music.service.impl;

import com.music.model.Music;
import com.music.repository.IMusicRepository;
import com.music.service.IMusicServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicServer {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public void addNewSong(Music music) {
        musicRepository.addNewSong(music);
    }

    @Override
    public List<Music> musicList() {
        return musicRepository.musicList();
    }

    @Override
    public void editMusic(Music music) {
        musicRepository.editMusic(music);
    }

    @Override
    public Music songId(int id) {
        return musicRepository.songId(id);
    }

    @Override
    public void deleteMusic(int id) {
        musicRepository.deleteMusic(id);
    }
}
