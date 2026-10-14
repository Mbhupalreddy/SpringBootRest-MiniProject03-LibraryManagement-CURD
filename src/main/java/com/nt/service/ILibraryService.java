package com.nt.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.nt.entity.LibraryEntity;


public interface ILibraryService {
	
	public String registerBook(@RequestBody LibraryEntity entity);

}
