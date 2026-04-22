package co.edu.uptc.products.repository;

import java.util.HashSet;
import java.util.Set;

import co.edu.uptc.products.domain.Product;

public class ProductRepository {
	
	private Set<Product> products;
	
	public ProductRepository() {
		this.products = new HashSet<Product>();
	}
	
	public boolean addProduct(Product product) {
		return this.products.add(product);
	}
	
	public Set<Product> findAll(){
		return this.products;
	}
	
	public Product findProductById(Product product) {
		return this.products.stream()
				.filter(p -> p.getPrice() > product.getPrice() &&
						p.getStock() >= product.getStock())
				.findFirst().orElse(null);
	}
	

}
