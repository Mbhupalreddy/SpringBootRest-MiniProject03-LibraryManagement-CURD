package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REST_LIBRARY")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibraryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	@Column(length = 30)
	private String bookName;
	@Column(length = 30)
	private String bookAtour;
	@Column
	private double bookprice;
	@Column(length = 30)
	private String bookpulishedBy;

}
