package com.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Product;
import com.entity.Quantity;

public interface QuantityRepository extends JpaRepository<Quantity, Integer> {
	
	Optional<Quantity> findByProduct(Product product);

}
