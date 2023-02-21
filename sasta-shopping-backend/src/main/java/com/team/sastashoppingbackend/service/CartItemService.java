package com.team.sastashoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.CartItem;
import com.team.sastashoppingbackend.entity.Product;
import com.team.sastashoppingbackend.entity.auth.User;
import com.team.sastashoppingbackend.repository.CartItemRepository;

import jakarta.transaction.Transactional;

@Service
public class CartItemService {
    
    @Autowired
    private CartItemRepository cartItemRepository;
    
    @Transactional
    public CartItem addCartItem(Long userId, Long productId, int quantity) {
        User user = new User();
        user.setId(userId);
        Product product = new Product();
        product.setId(productId);
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setUser(user);
        cartItem.setProduct(product);
        return cartItemRepository.save(cartItem);
    }
    
    @Transactional
    public void removeCartItem(Long userId, Long productId) {
        cartItemRepository.deleteByUserIdAndProductId(userId, productId);
    }
    @Transactional
    public void removeAllCartItems(Long userId) {
        cartItemRepository.deleteByUserId(userId);
    }
    
    public List<CartItem> getAllCartItems(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }
    
	@SuppressWarnings("deprecation")
	public CartItem getCartById(Long id) {
		// TODO Auto-generated method stub
		return cartItemRepository.getById(id);
	}
}
