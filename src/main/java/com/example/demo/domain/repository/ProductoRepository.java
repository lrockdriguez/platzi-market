package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.persistence.crud.ProductoCrudRepository;
import com.example.demo.persistence.entity.Producto;

public class ProductoRepository {
	
	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAll(){
		
		return (List<Producto>) productoCrudRepository.findAll();
		
		//return productoCrudRepository.findAll();	
	}
	
	public List<Producto> getByCategoria(int idCategoria){
		
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad){
		
		return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
		
	}

}
