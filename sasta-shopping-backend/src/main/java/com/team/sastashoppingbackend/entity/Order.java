package com.team.sastashoppingbackend.entity;

//import java.util.List;
//import java.util.UUID;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
//	private UUID orderId;
//
//	@OneToMany
//	@JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
//	private List<OrderItem> orderItems;
//
//}
