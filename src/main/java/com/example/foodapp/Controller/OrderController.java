package com.example.foodapp.Controller;

import com.example.foodapp.Entity.Order;
import com.example.foodapp.Repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable Long id,
            @RequestBody Order updatedOrder
    ) {
        Order order = orderRepository.findById(id).orElse(null);

        if (order != null) {
            order.setStatus(updatedOrder.getStatus());
            return orderRepository.save(order);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "Order deleted successfully";
    }
}