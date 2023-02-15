package com.team.sastashoppingbackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.sastashoppingbackend.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;

	
}
