package com.team.sastashoppingbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.sastashoppingbackend.entity.auth.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart_items")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

}
