package com.team.sastashoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.Product;
import com.team.sastashoppingbackend.exception.ResourceNotFoundException;
import com.team.sastashoppingbackend.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setImages(productDetails.getImages());
        return productRepository.save(product);
    }

    public ResponseEntity<?> deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
