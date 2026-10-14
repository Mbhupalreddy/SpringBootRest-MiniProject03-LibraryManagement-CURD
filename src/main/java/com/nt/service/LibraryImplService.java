package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.LibraryEntity;
import com.nt.repository.ILibraryInfoRepository;

@Service
public class LibraryImplService  implements ILibraryService{
	
	@Autowired
	ILibraryInfoRepository repo;

	@Override
	public String registerBook(LibraryEntity entity) {
		Integer bookId = repo.save(entity).getBookId();
		return "The Book Record is saved with id:" + bookId ;
	}

}
