package com.yuangao.java401d4.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    //all albums
    @GetMapping("/albums")
    public String getAllAlbumController(Model m){

        Iterable<Album> albums = albumRepository.findAll();

        m.addAttribute("albums",albums);
        return "allAlbum";
    }

    //create a new albums
    @PostMapping("/albums")
    public RedirectView addAlbum(String title ,String artist,int songCount,
                                 int length, String imageUrl){
        Album album = new Album (title, artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    //show particular album's information
    @GetMapping("/albumDetails/{id}")
    public String getAllSongsFromAlbum(@PathVariable Long id, Model m){

        Album a = albumRepository.findById(id).get();

        m.addAttribute("particularAlbum",a);
        return "albumDetails";
    }

    //add new songs
    @PostMapping("/albumDetails/{id}")
    public String addSong(@PathVariable Long id, @RequestParam String songTitle, @RequestParam int songLength,
                                @RequestParam int trackNumber ){
        Album a = albumRepository.findById(id).get();
        Song song = new Song(songTitle,songLength,trackNumber,a);
        songRepository.save(song);
        return "redirect:/albumDetails/{id}";
    }




}
