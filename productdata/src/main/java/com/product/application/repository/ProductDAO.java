package com.product.application.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.product.application.entity.ProductEntity;

@Repository
public class ProductDAO {

	@Autowired
	private ProductRepository repository;
	
	//save or update
	public ProductEntity saveProduct(ProductEntity entity) {
		return repository.save(entity);
	}
	
	//AllCustomer
		public List<ProductEntity> getAllProducts(){
			return repository.findAll();	
		}
		
		
	//getById
		public ProductEntity getProductDataById(Long id) {
			return repository.findById(id).orElse(new ProductEntity(0,HttpStatus.NOT_FOUND.name(),
					HttpStatus.NOT_FOUND.name()));//HttpStatus.NOT_FOUND.name() OR null
		}
		
   //deleteById
		public ProductEntity deleteProductDataById(Long id) {
			ProductEntity product = getProductDataById(id);
			if(product.getId()!=404) {
		        repository.deleteById(id);
			}
			return product;
		}
//   getproductbyname		
		public List<ProductEntity> getproductByName(String productName) {
			return repository.findByProductName(productName);
		}
		
//		sortedbynames
		public List<ProductEntity> sortProduct(String productName, int volume, float marketCapital, float creditRating ) {
			return repository.validateProductdetails(productName, volume, marketCapital, creditRating);	
		}
}
