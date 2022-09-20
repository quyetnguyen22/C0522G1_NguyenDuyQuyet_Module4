package com.example.music.model;

import javax.validation.constraints.*;

public class MusicDto {
    private Integer id;

    @NotBlank(message = "Can not be empty.")
    @Size(max = 800, message = "Can not be greater than 800 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Can not contain special characters")
    private String songName;
    @NotBlank(message = "Can not be empty.")
    @Size(max = 800, message = "Can not be greater than 300 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Can not contain special characters")
    private String singer;
    @NotBlank(message = "Can not be empty.")
    @Size(max = 800, message = "Can not be greater than 1000 characters")
    @Pattern(regexp = "^[a-zA-Z0-9,]*$", message = "Can not contain special characters except','")
    private String songType;
    private String pathSong;

    public MusicDto() {
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
