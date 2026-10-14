package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.LibraryEntity;
import com.nt.service.ILibraryService;

@RestController
@RequestMapping("/library")
public class LibraryMgmtController {
	@Autowired
	ILibraryService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> enterBook(@RequestBody LibraryEntity entity) {
		
		String reg = service.registerBook(entity);
		return new ResponseEntity<String>(reg,HttpStatus.CREATED);
		
	}

}
