package com.audiomanager.data;

import java.io.Serializable;
import java.util.List;


/**
 * Created by rares on 19.03.2016.
 */
public class Song implements Serializable {
    String songName;
    String artistName;
    String album;
    String duration;
    String genre;

    public Song(String songName, String artistName, String album, String duration, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.audiomanager.data.Song name: ").append(songName);
        sb.append("\nArtist: ").append(artistName);
        sb.append("\nDuration: ").append(duration);
        sb.append("\nGenre: ").append(genre);
        sb.append("\nAlbum: ").append(album);
        return String.valueOf(sb);
    }
}
