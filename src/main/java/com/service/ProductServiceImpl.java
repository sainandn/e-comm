package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.ProductRequestDTO;
import com.entity.Product;
import com.entity.Quantity;
import com.repository.ProductRepository;
import com.repository.QuantityRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	QuantityRepository quantityRepository;



	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	 public Product getProductById(int id) {
	        Optional<Product> product = productRepository.findById(id);
	        return product.orElse(null);  // or throw an exception if the product is not found
	    }
	@Transactional
	public Product saveProductandquantity(ProductRequestDTO productRequestDTO) {
	    Product product = new Product();
	    product.setProductCategory(productRequestDTO.getProduct().getProductCategory());
	    product.setProductName(productRequestDTO.getProduct().getProductName()); // Make sure this line exists
	    product.setProductDescription(productRequestDTO.getProduct().getProductDescription());
	    product.setProductPrice(productRequestDTO.getProduct().getProductPrice());
	    product.setProductCost(productRequestDTO.getProduct().getProductCost());

	    // Save the product
	    Product savedProduct = productRepository.save(product);

	    // Now save the quantity
	    Quantity quantity = new Quantity();
	    quantity.setProduct(savedProduct);
	    quantity.setQuantity(productRequestDTO.getQuantity().getQuantity());
	    quantityRepository.save(quantity);

	    return savedProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

}
