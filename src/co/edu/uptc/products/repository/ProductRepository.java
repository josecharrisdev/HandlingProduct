package co.edu.uptc.products.repository;

import java.util.HashSet;
import java.util.Objects;
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
	
	public Product findProductById(Long idProduct) {
		return this.products.stream()
				.filter(p -> p.getId().equals(idProduct) )
				.findFirst().orElse(null);
	}
	
	public boolean updateProduct(Product newProduct) {
		/* Identificamos el objeto anterior */
		Product oldProduct = this.findProductById(newProduct.getId());
		/* Se valida si hay el objeto existe */
		if(!Objects.isNull(oldProduct)) {
			/* Validaciones para que no se pierda la información
			 * Si el usuario no la envía por parámetro */
			if(Objects.isNull(newProduct.getName())) {
				newProduct.setName(oldProduct.getName());
			}
			if(Objects.isNull(newProduct.getPrice())) {
				newProduct.setPrice(oldProduct.getPrice());
			}
			if(Objects.isNull(newProduct.getStock())) {
				newProduct.setStock(oldProduct.getStock());
			}
			/* Eliminamos el registro actual */
			this.products.remove(oldProduct);
			
			/* Se agrega el nuevo producto */
			this.products.add(newProduct);
			return true;
		}
		
		return false;
	}
	
	public boolean delete(Long idProduct) {
		return this.products.removeIf(product -> 
			product.getId().equals(idProduct));
	}
	

}
