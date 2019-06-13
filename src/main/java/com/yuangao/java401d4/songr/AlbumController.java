package com.yuangao.java401d4.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getNotController(Model m){

        Iterable<Album> albums = albumRepository.findAll();

        m.addAttribute("albums",albums);
        return "allAlbum";
    }
}
