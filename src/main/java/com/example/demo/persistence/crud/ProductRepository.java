package com.example.demo.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.dto.Product;

public interface ProductRepository {
	
	List<Product> getAll();
	
	Optional<List<Product>> getByCategory(int categoryId);
	
	Optional<List<Product>> getScarseProducts(int quatity);
	
	Optional<Product> getProduct(int productId);
	
	Product save(Product product);
	
	void delete(int productId);

}
