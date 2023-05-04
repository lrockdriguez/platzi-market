package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.dto.Product;
import com.example.demo.domain.dto.ProductRepository;
import com.example.demo.persistence.crud.ProductoCrudRepository;
import com.example.demo.persistence.entity.Producto;
import com.example.demo.persistence.mapper.ProductMapper;


@Repository
public class ProductoRepository implements ProductRepository {
	
	@Autowired
	private ProductMapper mapper;
	
	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	
	
	@Override
	public List<Product> getAll(){
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		
		return mapper.toProducts(productos);
		//return productoCrudRepository.findAll();	
	}
	
	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productoId) {
		return productoCrudRepository.findById(productoId).map(producto -> mapper.toProduct(producto));
		
	}
	
	@Override
	public void delete(int productoId) {
		productoCrudRepository.deleteById(productoId);
		
	}


	@Override
	public Product save(Product product) {
		
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}
	
	
	//public List<Producto> getByCategoria(int idCategoria){
		
		//return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	//}
	
	//public Optional<List<Producto>> getEscasos(int cantidad){
		
	//	return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
		
	//}
	
	//public Optional<Producto> getProducto(int idProducto){
		
		//return productoCrudRepository.findById(idProducto);
		
	//} 
	
	//public Producto save(Producto producto) {
		
		//return productoCrudRepository.save(producto);
	//}
	
	
	//public void delete(int idProducto) {
		//productoCrudRepository.deleteById(idProducto);
		
	//}



}
