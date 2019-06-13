package com.yuangao.java401d4.songr;

import org.springframework.data.repository.CrudRepository;

// sets up how Spring will interact with the database to retrieve/save/etc Album
public interface AlbumRepository extends CrudRepository<Album, Long>{

}
