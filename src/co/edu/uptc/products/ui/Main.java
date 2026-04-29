package co.edu.uptc.products.ui;

import co.edu.uptc.products.domain.Product;
import co.edu.uptc.products.service.ProductService;

/** 
 * 
 */
public class Main {
	public static void main(String[] args) {
		
		/* Se crea la instancia a la clase que realiza la lógica */
		ProductService productService = new ProductService();
		
		System.out.println("\tResultado de inserciones");
		/* Inserción válida */
		System.out.println(
				productService.addProduct(new Product(1L, "Name", 120000d, 10)));
		
		/* Inserciones inválida según validaciones realizadas */
		/* Precio es cero*/
		System.out.println(
				productService.addProduct(new Product(2L, "Name", 0d, 10)));
		
		System.out.println(
				productService.addProduct(new Product(2L, "Name", 120000d, -1)));
		
		/* Listado de información */
		System.out.println("\tListado de información");
		productService.findAll().forEach(System.out::println);
		
		/* Búsqueda de información */
		System.out.println("\t Búsqueda de información por ID");
		System.out.println(productService.findProductById(1L));
		/* No encuentra el id ya que la inserción no se realizó
		 * por validación fallida */
		System.out.println(productService.findProductById(2L));
		
		/* Actualización */
		Product product = productService.findProductById(1L);
		/* Se actualiza la información de nombre y stock
		 * pero no se actualiza la información de id y precio
		 * así que debería conservar el id y precio anterior*/
		product.setName("Producto de Limpieza");
		product.setStock(20);
		productService.updateProduct(product);
		System.out.println("\t Actualización");
		System.out.println(productService.findProductById(1L));
		
		/* Se realiza la eliminación */
		productService.deleteProduct(1L);
		/* Ahora ya no debería aparecer */
		System.out.println("\n Eliminación");
		/* Sebe aparecer null*/
		System.out.println(productService.findProductById(1L));
		
		
		
	}
}
