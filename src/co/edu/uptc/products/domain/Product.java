package co.edu.uptc.products.domain;

import java.util.Objects;

/** 
 * <b>Descripción: </b> Clase de modelo que representa
 * la información del producto <br>
 * 
 * @author jcharris
*/
public class Product {
	
	/** Atributo que determina el identificador de la clase*/
	private Long id;
	
	/** Atributo que determina el nombre del producto */
	private String name;
	
	/** Atributo que determina el precio del product */
	private Double price;
	
	/** Atributo que determina la cantidad disponible de productos*/
	private Integer stock;
	
	/**
	 * <b>Description: </b> Constructor vacío de la clase 
	 */
	public Product() {
		
	}

	/**
	 * <b>Description: </b> Constructor de la clase<br>
	 * @param id Parámetro que determina el identificador de la clase 
	 * @param name Parámetro que determina el nombre del producto
	 * @param price Parámetro que determina el precio del producto
	 * @param stock Parámetro que determina el stock del producto
	 */
	public Product(Long id, String name, Double price, Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	/**
	 * <b>Description: </b> Retorna el valor del ID
	 * @return id Retorna el identificador del producto
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo valor de ID<br>
	 * @param id Representa el nuevo identificador del producto
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Product auxProduct = (Product) obj;
		return this.id.equals(auxProduct.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
}
