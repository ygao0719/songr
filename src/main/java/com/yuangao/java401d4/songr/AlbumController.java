package com.yuangao.java401d4.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getNotController(Model m){

        Iterable<Album> albums = albumRepository.findAll();

        m.addAttribute("albums",albums);
        return "allAlbum";
    }


    @PostMapping("/albums")
    public RedirectView addAlbum(String title ,String artist,int songCount,
                                 int length, String imageUrl){
        Album album = new Album (title, artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/albums/{id}")
    public String getAllSongsFromalbum(@PathVariable long id, Model m){
        Album a = albumRepository.findById(id).get();
        Iterable<Song> songs = a.getSongs();
        m.addAttribute("songs",songs);
        return "allSongs";
    }



}
