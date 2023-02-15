package com.team.sastashoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.dto.ProductDTO;
import com.team.sastashoppingbackend.entity.Product;
import com.team.sastashoppingbackend.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product product : products) {
			productDTOs.add(new ProductDTO(product.getId(), product.getName(), product.getDescription(),
					product.getPrice(), product.getQuantity()));
		}
		return productDTOs;
	}

	public ProductDTO getProductById(long id) {
		Product product = productRepository.findById(id).orElse(null);
		if (product == null) {
			return null;
		}
		return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
				product.getQuantity());
	}

	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product = productRepository.save(product);
		return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
				product.getQuantity());
	}

	public ProductDTO updateProduct(long id, ProductDTO productDTO) {
		Product product = productRepository.findById(id).orElse(null);
		if (product == null) {
			return null;
		}
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product = productRepository.save(product);
		return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
				product.getQuantity());
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
}