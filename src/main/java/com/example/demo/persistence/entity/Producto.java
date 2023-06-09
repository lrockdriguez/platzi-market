package com.example.demo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "productos")
@Getter
@Setter
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_producto")
	private Integer idProducto;
	
	private String nombre;
	
	@Column(name="id_categoria")
	private Integer idCategoria;
	
	@Column(name="codigo_barras")
	private String codigoBarras;
	
	@Column(name="precio_venta")
	private Double precioVenta;
	
	@Column(name="cantidad_stock")
	private Integer cantidadStock;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", insertable = false, updatable=false)
	private Categoria categoria;
		

}
