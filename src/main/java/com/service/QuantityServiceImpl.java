package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Quantity;
import com.repository.QuantityRepository;

@Service
public class QuantityServiceImpl implements QuantityService {
	@Autowired
	private QuantityRepository quantityRepository;

	@Override
	public Quantity getQuantityByProduct(Product product) {
		return quantityRepository.findByProduct(product).orElseThrow(() -> new RuntimeException("Quantity not found"));
	}

	@Override
	public Quantity saveQuantity(Quantity quantity) {
		return quantityRepository.save(quantity);
	}
}
