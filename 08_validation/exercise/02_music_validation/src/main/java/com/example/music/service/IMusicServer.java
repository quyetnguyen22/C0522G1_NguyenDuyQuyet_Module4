package com.example.music.service;

import com.example.music.model.Music;

import java.util.List;

public interface IMusicServer {
    void addNewSong(Music music);

    List<Music> musicList();

    void editMusic(Music music);

    Music songId(int id);

    void deleteMusic(int id);
}
