package com.team.sastashoppingbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.sastashoppingbackend.entity.Product;
import com.team.sastashoppingbackend.repository.ProductRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/product")
public class RestController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/all")
	public List<Product> findAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> findProductById(@PathVariable(value = "id") long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok().body(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Product saveUser(@Validated @RequestBody Product product) {
		return productRepository.save(product);
	}

}
