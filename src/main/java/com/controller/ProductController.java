package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dto.ProductRequestDTO;
import com.entity.Product;
import com.entity.Quantity;
import com.service.ProductService;
import com.service.QuantityService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	QuantityService quantityService;

	@PostMapping("/save")
	public Product saveProductandquantity(@RequestBody ProductRequestDTO productRequestDTO) {
		return productService.saveProductandquantity(productRequestDTO);
	}

	@GetMapping("/getall")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	 @GetMapping("/getproduct")
	    public ResponseEntity<Product> getProductById(@RequestParam Integer id) {
	        Product product = productService.getProductById(id);
	        return ResponseEntity.ok(product);
	    }
		
		
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDTO productRequestDTO) {
		Product product = productService.getProductById(id);
		product.setProductCategory(productRequestDTO.getProduct().getProductCategory());
		product.setProductName(productRequestDTO.getProduct().getProductName());
		product.setProductDescription(productRequestDTO.getProduct().getProductDescription());
		product.setProductPrice(productRequestDTO.getProduct().getProductPrice());
		product.setProductCost(productRequestDTO.getProduct().getProductCost());

		Quantity quantity = quantityService.getQuantityByProduct(product);
		quantity.setQuantity(productRequestDTO.getQuantity().getQuantity());

		quantityService.saveQuantity(quantity);

		return productService.saveProductandquantity(productRequestDTO);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}
}
