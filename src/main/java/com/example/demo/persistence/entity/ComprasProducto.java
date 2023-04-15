package com.example.demo.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
public class ComprasProducto {
	
	@EmbeddedId
	private ComprasProductoPK id;
	
	private Integer cantidad;
	
	private Double total;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_compra", insertable = false, updatable = false)
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private Producto producto;

}
