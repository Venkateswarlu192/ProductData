package com.product.application.controllor;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.application.dto.ProductDto;
import com.product.application.dto.ResponseStructure;
import com.product.application.entity.ProductEntity;
import com.product.application.service.ProductService;


@RestController
//@RequestMapping("/api/product")
public class ProductControllor {

	@Autowired
	private ProductService service;
	
//	Insert
	@PostMapping("/addProduct")
	public @ResponseBody ResponseStructure<ProductEntity> addProduct(@RequestBody ProductDto dto) {
		return service.addProduct(dto);
	}
	
//	update
	@PutMapping("/updateProduct")
	public ResponseStructure<ProductEntity> updateProduct(@RequestBody ProductEntity entity) {
		return service.updateProduct(entity);
	}
	
//All ProductDetails
		@GetMapping(value ="/allProduct")
		public @ResponseBody ResponseStructure<List<ProductEntity>> getAllCustomer() {
			return service.getAllProduct();
		}
		
//getById
		@GetMapping(value ="/getdataById/{id}")// {id} excepting dynamic data doesn't
		public @ResponseBody ResponseStructure<ProductEntity> getdataById(@PathVariable Long id) {
			return service.getDataById(id);
		}
		
//deleteById	
		@DeleteMapping(value ="/deletById/{id}")
		public @ResponseBody ProductEntity deletById( @PathVariable Long id ){
			return service.deleteProductById(id);	
		}
		
//		Custom methods
		
		   // getProductByName
			@GetMapping(value ="/byname/{productName}") //{name} excepting dynamic data doesn't
			public @ResponseBody List<ProductEntity> getproductByName( @PathVariable String productName) {
				return service.getProductByName(productName);
				
			}
			
    //validateproduct
			@GetMapping(value ="/validate")
			public @ResponseBody List<ProductEntity> validateproduct(@RequestParam(required = false, defaultValue ="pname") String productName, @RequestParam(required = false, defaultValue = "0") int volume,
					     @RequestParam(required = false, defaultValue ="0") float marketCapital, @RequestParam(required = false, defaultValue = "0") float creditRating){
				return service.validateProduct(productName, volume, marketCapital, creditRating);					
			}
			


}
