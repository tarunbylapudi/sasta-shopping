package com.team.sastashoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.OrderItem;
import com.team.sastashoppingbackend.exception.ResourceNotFoundException;
import com.team.sastashoppingbackend.repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem", "id", id));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = getOrderItemById(id);
        orderItem.setQuantity(orderItemDetails.getQuantity());
        orderItem.setProduct(orderItemDetails.getProduct());
        orderItem.setOrder(orderItemDetails.getOrder());
        return orderItemRepository.save(orderItem);
    }

    public ResponseEntity<?> deleteOrderItem(Long id) {
        OrderItem orderItem = getOrderItemById(id);
        orderItemRepository.delete(orderItem);
        return ResponseEntity.ok().build();
    }
}
