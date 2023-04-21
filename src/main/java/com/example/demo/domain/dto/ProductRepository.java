package com.example.demo.domain.dto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
	
	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<List<Product>> getScarseProducts(int quality);
	Optional<Product> getProduct(int productoId);
	Product save(Product product);
	void delete(int productId); 
	

}