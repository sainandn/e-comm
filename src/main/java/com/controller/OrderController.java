package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Order;
import com.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
	}

	@DeleteMapping("/{orderId}")
	public void cancelOrder(@PathVariable Integer orderId) {
		orderService.cancelOrder(orderId);
	}
}
