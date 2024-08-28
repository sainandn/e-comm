package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dto.ProductRequestDTO;
import com.entity.Product;

public interface ProductService {
	  List<Product> getAllProducts();

	 Product getProductById(int id);

	Product saveProductandquantity(ProductRequestDTO productRequestDTO);

	void deleteProduct(Integer id);
}
