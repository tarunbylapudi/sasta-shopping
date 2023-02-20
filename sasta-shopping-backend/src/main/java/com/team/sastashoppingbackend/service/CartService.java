package com.team.sastashoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.Cart;
import com.team.sastashoppingbackend.entity.CartItems;
import com.team.sastashoppingbackend.entity.Product;
import com.team.sastashoppingbackend.entity.auth.User;
import com.team.sastashoppingbackend.repository.CartItemsRepository;
import com.team.sastashoppingbackend.repository.CartRepository;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private CartItemsRepository cartItemsRepository;

  public Cart createCart(User user) {
    Cart cart = new Cart();
    cart.setUser(user);
    cart.setItems(new ArrayList<CartItems>());
    return cartRepository.save(cart);
  }

  public Cart findByUser(Long userId) {
    return cartRepository.findByUser(userId).get();
  }

  public void addItemToCart(Cart cart, Product product, int quantity) {
    CartItems cartItem = new CartItems();
    cartItem.setCart(cart);
    cartItem.setProduct(product);
    cartItem.setQuantity(quantity);
    cart.getItems().add(cartItem);
    cartRepository.save(cart);
  }

  public List<CartItems> getCartItems(Cart cart) {
    return cart.getItems();
  }

  public void removeItemFromCart(CartItems cartItem) {
    cartItemsRepository.delete(cartItem);
  }

}
