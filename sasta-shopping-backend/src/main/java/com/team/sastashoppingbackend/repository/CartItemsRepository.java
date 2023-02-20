package com.team.sastashoppingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.sastashoppingbackend.entity.CartItems;
@Repository
public interface CartItemsRepository  extends JpaRepository<CartItems, Long>  {

}
