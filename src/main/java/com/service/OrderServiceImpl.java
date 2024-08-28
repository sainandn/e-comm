package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Order;
import com.entity.Product;
import com.entity.Quantity;
import com.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private QuantityService quantityService;

	@Override
	public Order placeOrder(Order order) {
		Product product = productService.getProductById(order.getProduct().getProductId());
		Quantity quantity = quantityService.getQuantityByProduct(product);

		if (quantity.getQuantity() < order.getOrderQuantity()) {
			throw new RuntimeException("Not enough stock available");
		}

		quantity.setQuantity(quantity.getQuantity() - order.getOrderQuantity());
		quantityService.saveQuantity(quantity);

		return orderRepository.save(order);
	}

	@Override
	public void cancelOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

		Product product = order.getProduct();
		Quantity quantity = quantityService.getQuantityByProduct(product);

		quantity.setQuantity(quantity.getQuantity() + order.getOrderQuantity());
		quantityService.saveQuantity(quantity);

		orderRepository.deleteById(orderId);
	}
}
