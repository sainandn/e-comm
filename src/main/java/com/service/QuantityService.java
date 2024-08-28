package com.service;

import com.entity.Product;
import com.entity.Quantity;

public interface QuantityService {
	Quantity getQuantityByProduct(Product product);

	Quantity saveQuantity(Quantity quantity);
}
