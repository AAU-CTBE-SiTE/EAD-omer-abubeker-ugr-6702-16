
package com.example.restaurantorderingsystem.service;

import com.example.restaurantorderingsystem.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private Long nextId = 1L;

    // CREATE
    public Order createOrder(Order order) {
        order.setId(nextId++);
        if (order.getStatus() == null || order.getStatus().isBlank()) {
            order.setStatus("PENDING");
        }

        orders.add(order);
        return order;
    }

    // GET ALL
    public List<Order> getAllOrders() {
        return orders;
    }

    // GET BY ID
    public Order getOrderById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Order not found: " + id));
    }

    // UPDATE
    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = getOrderById(id);

        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        existingOrder.setFoodName(updatedOrder.getFoodName());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setStatus(updatedOrder.getStatus());

        return existingOrder;
    }

    // DELETE
    public void deleteOrder(Long id) {
        Order existingOrder = getOrderById(id);
        orders.remove(existingOrder);
    }
}
