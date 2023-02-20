package com.team.sastashoppingbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.sastashoppingbackend.entity.CartItem;
import com.team.sastashoppingbackend.service.CartItemService;

@RestController
@RequestMapping("/cartitems")
public class CartItemController {
    
    @Autowired
    private CartItemService cartItemService;
    
    @PostMapping("/{productId}/{quantity}")
    public CartItem addCartItem(@PathVariable Long productId, @PathVariable int quantity, @RequestHeader("userId") Long userId) {
        return cartItemService.addCartItem(userId, productId, quantity);
    }
    
    @DeleteMapping("/{productId}")
    public void removeCartItem(@PathVariable Long productId, @RequestHeader("userId") Long userId) {
        cartItemService.removeCartItem(userId, productId);
    }
    
    @DeleteMapping
    public void removeAllCartItems(@RequestHeader("userId") Long userId) {
        cartItemService.removeAllCartItems(userId);
    }
    
    @GetMapping
    public List<CartItem> getAllCartItems(@RequestHeader("userId") Long userId) {
        return cartItemService.getAllCartItems(userId);
    }
}
