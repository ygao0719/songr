package com.yuangao.java401d4.songr;


import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Album model
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;

    public Album(){}
    public Album(String title,String artist,int songCount,int length,String imageUrl){

        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public int getSongCount(){
        return this.songCount;
    }

    public int getLength(){
        return this.length;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }
}
