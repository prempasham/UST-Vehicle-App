package com.ust.pms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.pms.model.Product;
import com.ust.pms.model.User;
import com.ust.pms.repo.ProductRepository;
import com.ust.pms.repo.UserRepository;
import com.ust.pms.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	/*
	 * @Autowired private ProductRepository productRepository;
	 */
	@Autowired
	private ProductService productService;

	List<Product> products = new ArrayList<Product>();

	@GetMapping()
	public ResponseEntity<List<Product>> getProducts() {
		products = productService.getProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// Saving the product
	@PostMapping()
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		System.out.println(product);
		String result = productService.saveProduct(product);
		if (result.equalsIgnoreCase("Product Saved Successfully")) {
			System.out.println("Record saved Successfully");
			return new ResponseEntity<String>("Record saved Successfully", HttpStatus.CREATED);
		} else {
			System.out.println("Record Not saved Successfully");
			return new ResponseEntity<String>("Record Not saved Successfully", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	// Getting a single product
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Integer productId) {
		System.out.println("Product id called");
		if (productService.isProductExists(productId)) {
			Product product = productService.getProduct(productId);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}

	// delete
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId) {
		System.out.println("Delete controller");
		if (productService.isProductExists(productId)) {
			productService.deleteProduct(productId);
			return new ResponseEntity<String>("Deleted Ok", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Deleted not ", HttpStatus.NO_CONTENT);

		}
	}

	// update
	@PutMapping()
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {

		if (productService.isProductExists(product.getProductId())) {
			String result = productService.updateProduct(product);
			if (result.equalsIgnoreCase("Product Updated Successfully")) {
				System.out.println("Product Updated Successfully");
				return new ResponseEntity<String>("Updated Ok", HttpStatus.OK);
			} else {
				System.out.println("Product not Updated Successfully");
				return new ResponseEntity<String>("Updated failed ", HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			return new ResponseEntity<String>("Record Not Found ", HttpStatus.NOT_FOUND);

		}

	}
	/*
	 * @Autowired private UserRepository userRepository;
	 * 
	 * 
	 * @PostMapping("/register") public ResponseEntity<String> saveUser(@RequestBody
	 * User user) { userRepository.save(user); return new
	 * ResponseEntity<String>("Registration Successfully ", HttpStatus.CREATED); }
	 * 
	 * @PostMapping("/login") public ResponseEntity<User> confirm(@RequestBody User
	 * user) { User info =
	 * userRepository.findByUserNameAndPassword(user.getUserName(),
	 * user.getPassword()); if (info != null) { if
	 * ((user.getUserName()).equals(info.getUserName()) &&
	 * ((user.getPassword()).equals(info.getPassword()) )) { return new
	 * ResponseEntity<User>(HttpStatus.OK); } else return new
	 * ResponseEntity<User>(HttpStatus.UNAUTHORIZED); } return new
	 * ResponseEntity<User>(info, HttpStatus.NOT_FOUND); }
	 */

	/*
	 * private List<Product> products = new ArrayList<>( Arrays.asList(new
	 * Product(7222, "Mouse", 233, 900), new Product(3343, "Bags", 8900, 80), new
	 * Product(4334, "Shoes", 5600, 1200), new Product(4834, "Socks", 600, 200)));
	 */
	/*
	 * // all products
	 * 
	 * @GetMapping public ResponseEntity<List<Product>> getProducts() { products =
	 * (List<Product>) productRepository.findAll(); return new
	 * ResponseEntity<List<Product>>(products, HttpStatus.OK); }
	 */

	/*
	 * // save
	 * 
	 * @PostMapping public ResponseEntity<String> saveProduct(@RequestBody Product
	 * product) { System.out.println(product); productRepository.save(product);
	 * return new ResponseEntity<String>("Record saved Successfully ",
	 * HttpStatus.CREATED); }
	 */

	/*
	 * // get product
	 * 
	 * @GetMapping("/{productId}") public ResponseEntity<Product>
	 * getProduct(@PathVariable("productId") Integer id) { if
	 * (productRepository.existsById(id)) { Optional<Product> p =
	 * productRepository.findById(id); Product product = p.get(); return new
	 * ResponseEntity<Product>(product, HttpStatus.OK); } else { return new
	 * ResponseEntity<Product>(HttpStatus.NO_CONTENT); }
	 * 
	 * }
	 */

	/*
	 * // delete
	 * 
	 * @DeleteMapping("{productId}") public ResponseEntity<String>
	 * deleteProduct(@PathVariable("productId") Integer id) { if
	 * (productRepository.existsById(id)) { productRepository.deleteById(id);
	 * 
	 * return new ResponseEntity<String>("Deleted Ok", HttpStatus.OK); } else {
	 * return new ResponseEntity<String>("Deleted Not", HttpStatus.NO_CONTENT); } }
	 */

	/*
	 * // update
	 * 
	 * @PutMapping public ResponseEntity<String> updatProduct(@RequestBody Product
	 * product) { if (productRepository.existsById(product.getProductId())) {
	 * productRepository.save(product); return new
	 * ResponseEntity<String>("Updated Successfully", HttpStatus.OK); } else {
	 * return new ResponseEntity<String>("Update failed", HttpStatus.NO_CONTENT); }
	 * }
	 */
}
