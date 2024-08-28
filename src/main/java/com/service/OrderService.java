package com.service;

import com.entity.Order;

public interface OrderService {
	Order placeOrder(Order order);

	void cancelOrder(Integer orderId);
}
