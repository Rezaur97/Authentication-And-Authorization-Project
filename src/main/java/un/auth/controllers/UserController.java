package un.auth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import un.auth.entity.Products;
import un.auth.services.ProductService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getProducts")
	public ResponseEntity<?> getData(){
		List<Products> allProducts = productService.getAllProducts();
		if(allProducts != null && !allProducts.isEmpty()) {
			return new ResponseEntity<>(allProducts ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/createProduct")
	public Products createProduct(@RequestBody Products p) {
		return productService.saveProduct(p);
	}
	
}
