package com.nt.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.entity.LibraryEntity;


public interface ILibraryService {
	
	public String registerBook(@RequestBody LibraryEntity entity);
	public LibraryEntity findingBookbyId(@PathVariable Integer id);
	public List<LibraryEntity> fetchAllRecords();
	public String removeById(@PathVariable Integer id);
	public String UpdatedRecordByid(@RequestBody LibraryEntity entity);

}
