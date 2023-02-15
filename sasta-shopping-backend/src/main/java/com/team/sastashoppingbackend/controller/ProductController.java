package com.team.sastashoppingbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.sastashoppingbackend.dto.ProductDTO;
import com.team.sastashoppingbackend.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}

	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}
}