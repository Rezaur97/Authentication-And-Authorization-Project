package un.auth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import un.auth.entity.Products;
import un.auth.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prepo;
	
	@Override
	public List<Products> getAllProducts() {
		List<Products> all = prepo.findAll();
		return all;
	}

	@Override
	public Products saveProduct(Products p) {
		Products savedProduct = prepo.save(p);
		return savedProduct;
	}

}
