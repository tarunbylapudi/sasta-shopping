package com.team.sastashoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.Cart;
import com.team.sastashoppingbackend.entity.CartItem;
import com.team.sastashoppingbackend.entity.Product;
import com.team.sastashoppingbackend.entity.auth.User;
import com.team.sastashoppingbackend.repository.CartItemRepository;
import com.team.sastashoppingbackend.repository.CartRepository;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private CartItemRepository cartItemRepository;

  public Cart createCart(User user) {
    Cart cart = new Cart();
    cart.setUser(user);
    cart.setItems(new ArrayList<CartItem>());
    return cartRepository.save(cart);
  }

  public Cart findByUser(Long userId) {
    return cartRepository.findByUser(userId).get();
  }

  public void addItemToCart(Cart cart, Product product, int quantity) {
    CartItem cartItem = new CartItem();
    cartItem.setCart(cart);
    cartItem.setProduct(product);
    cartItem.setQuantity(quantity);
    cart.getItems().add(cartItem);
    cartRepository.save(cart);
  }

  public List<CartItem> getCartItems(Cart cart) {
    return cart.getItems();
  }

  public void removeItemFromCart(CartItem cartItem) {
	  cartItemRepository.delete(cartItem);
  }

}
