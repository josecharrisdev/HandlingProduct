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
		return new HashSet<>(products);
	}
	
	public Product findProductById(Long idProduct) {
		return this.products.stream()
				.filter(p -> p.getId().equals(idProduct) )
				.findFirst().orElse(null);
	}
	
	public void updateProduct(Product newProduct) {
		/* Eliminamos el registro actual */
		this.products.remove(newProduct);
		/* Se agrega el nuevo producto */
		this.products.add(newProduct);
	}
	
	public boolean delete(Long idProduct) {
		return this.products.removeIf(product -> 
			product.getId().equals(idProduct));
	}
	

}
