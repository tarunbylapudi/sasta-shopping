package com.team.sastashoppingbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.sastashoppingbackend.entity.CartItem;
@Repository
public interface CartItemRepository  extends JpaRepository<CartItem, Long>  {


	void deleteByUserId(Long userId);

	void deleteByUserIdAndProductId(Long userId, Long productId);

	List<CartItem> findByUserId(Long userId);

}
