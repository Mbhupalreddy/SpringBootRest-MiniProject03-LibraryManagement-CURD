package com.nt.service;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public LibraryEntity findingBookbyId(Integer id) {
		
	return	repo.findById(id).orElseThrow(()->new IllegalArgumentException("Book is not found with this id" + id));
		
	}
	@Override
	public List<LibraryEntity> fetchAllRecords() {
		 
		return repo.findAll(); 
	}
	
	@Override
	public String removeById(Integer id) {
		Optional<LibraryEntity> byId = repo.findById(id);
		if(byId.isPresent()) {
			repo.deleteById(id);
			return id +"BookId is found and deleted!";
		}else {
			throw new IllegalArgumentException("The id is not found!"+id);
		}
		
	}
	@Override
	public String UpdatedRecordByid(LibraryEntity entity) {
		Optional<LibraryEntity> byId = repo.findById(entity.getBookId());
		if(byId.isPresent()) {
			repo.save(entity).getBookId();
			return"The BookId and data  is Updated! "+entity.getBookId();
		}else {
		return "Book id is not found";
		}
	}
	
	
}
