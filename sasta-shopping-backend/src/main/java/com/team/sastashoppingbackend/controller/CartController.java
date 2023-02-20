package com.team.sastashoppingbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.sastashoppingbackend.entity.Cart;
import com.team.sastashoppingbackend.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping
	public Cart findByUser(Long userId) {
		
		return cartService.findByUser(userId);
		
	}
}
