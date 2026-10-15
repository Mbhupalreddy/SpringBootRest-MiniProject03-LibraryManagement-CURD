package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/bookid/{id}")
	public ResponseEntity<LibraryEntity> getBookByid(@PathVariable Integer id){
		LibraryEntity findingBookbyId = service.findingBookbyId(id);
		return new  ResponseEntity<LibraryEntity>(findingBookbyId,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List> GetAllRecords(){
		List<LibraryEntity> all = service.fetchAllRecords();
		return new ResponseEntity<List>(all,HttpStatus.OK);
	}
	
	@GetMapping("/findall")
	public Page<LibraryEntity> findAll(Pageable pageable) {
	    return service.findAllRecords(pageable);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateRecords(@RequestBody LibraryEntity entity){
		String updated = service.UpdatedRecordByid(entity);
		return new ResponseEntity<String>(updated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> updateRecords(@PathVariable Integer id){
		String remove = service.removeById(id);
		return new ResponseEntity<String>(remove,HttpStatus.OK);
	}
	
	
	
}
