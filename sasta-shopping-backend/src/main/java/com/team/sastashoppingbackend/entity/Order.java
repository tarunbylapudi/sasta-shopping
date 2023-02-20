package com.team.sastashoppingbackend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.sastashoppingbackend.entity.auth.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@OneToMany(mappedBy="order", fetch = FetchType.EAGER)
	private List<OrderItem> orderItems;
	@ManyToOne()
	@JoinColumn(name="user_id")
	@JsonIgnore
	User user;

}
