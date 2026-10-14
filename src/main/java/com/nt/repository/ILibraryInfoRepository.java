package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.LibraryEntity;
@Repository
public interface ILibraryInfoRepository extends JpaRepository<LibraryEntity, Integer> {

}
