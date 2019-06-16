package com.yuangao.java401d4.songr;


import javax.persistence.*;

//song model
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String songTitle;
    int songLength;
    int trackNumber;
    @ManyToOne
    Album album;

    public Song(){}

    public Song(String songTitle,int songLength,int trackNumber,Album album){

        this.songTitle = songTitle;
        this.songLength = songLength;
        this.trackNumber = trackNumber;
        this.album = album;
    }
    public long getId(){
        return this.id;
    }
    public String getSongTitle(){
        return songTitle;
    }

    public int getSongLength(){
        return songLength;
    }

    public int getTrackNumber(){
        return trackNumber;
    }

    public Album getAlbum(){
        return album;
    }
}
