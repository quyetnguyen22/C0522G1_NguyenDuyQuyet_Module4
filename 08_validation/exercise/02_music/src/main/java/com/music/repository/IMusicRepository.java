package com.music.repository;

import com.music.model.Music;

import java.util.List;

public interface IMusicRepository {
    void addNewSong(Music music);

    List<Music> musicList();

    void editMusic(Music music);

    Music songId(int id);

    void deleteMusic(int id);
}
