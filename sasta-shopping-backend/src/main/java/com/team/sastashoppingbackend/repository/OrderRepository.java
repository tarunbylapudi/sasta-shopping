package com.team.sastashoppingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.sastashoppingbackend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
