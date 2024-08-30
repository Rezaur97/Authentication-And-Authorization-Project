package un.auth.services;

import java.util.List;

import un.auth.entity.Products;

public interface ProductService {
	
	public List<Products> getAllProducts();

	public Products saveProduct(Products p);
}
