package co.edu.uptc.products.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.products.domain.Product;
import co.edu.uptc.products.repository.ProductRepository;

public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService() {
		this.productRepository = new ProductRepository();
	}
	
	private boolean validate(Product product) {
		if(product.getPrice() <= 0) {
			return false;
		}
		if(product.getStock() < 0) {
			return false;
		}
		return true;
	}
	
	public boolean addProduct(Product product) {
		if(this.validate(product)) {
			return this.productRepository.addProduct(product);
		}
		return false;
	}
	
	public Set<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	public Product findProductById(Long idProduct) {
		return this.productRepository.findProductById(idProduct);
	}
	
	public boolean updateProduct(Product product) {
		if(this.validate(product)) {
			/* Identificamos el objeto anterior */
			Product oldProduct = this.productRepository.findProductById(product.getId());
			if(!Objects.isNull(oldProduct)) {
				return this.productRepository.updateProduct(product);
			}
			return false;
		}
		return false;
	}
	
	public boolean deleteProduct(Long idProduct) {
		return this.productRepository.delete(idProduct);
	}
	
	
	
}
