package com.example.music.model;

import javax.persistence.*;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String songName;
    private String singer;

    @Column(columnDefinition = "TEXT")
    private String songType;
    private String pathSong;

    public Music() {
    }

    public Music(Integer id, String songName, String singer, String songType, String pathSong) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.songType = songType;
        this.pathSong = pathSong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getPathSong() {
        return pathSong;
    }

    public void setPathSong(String pathSong) {
        this.pathSong = pathSong;
    }
}
