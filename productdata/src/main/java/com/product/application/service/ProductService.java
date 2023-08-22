package com.product.application.service;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.application.dto.ProductDto;
import com.product.application.entity.ProductEntity;
import com.product.application.repository.ProductDAO;
import com.product.application.repository.ProductRepository;
import com.product.application.dto.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public ResponseStructure<ProductEntity> addProduct(ProductDto dto) {
		ProductEntity product = new ProductEntity(dto);
		ResponseStructure<ProductEntity> structure = new ResponseStructure<>();//responce
		structure.setData(product);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Product data saved sucessfully");
		structure.setTimeStamp(LocalDateTime.now());
		return structure;
	}
	
//	update
	public ResponseStructure<ProductEntity> updateProduct(ProductEntity entity) {
		ProductEntity pro =dao.saveProduct(entity);
		 ResponseStructure<ProductEntity> structure = new ResponseStructure<>();
		 structure.setData(pro);
		 structure.setStatusCode(HttpStatus.ACCEPTED.value());
		 structure.setTimeStamp(LocalDateTime.now());
		 structure.setMessage(HttpStatus.ACCEPTED.name());
		 return structure;
	}
	
//	getAllProduct
	public ResponseStructure<List<ProductEntity>> getAllProduct(){
		 List<ProductEntity> list = dao.getAllProducts();
		 ResponseStructure<List<ProductEntity>> structure = new ResponseStructure<>();
		 if(list.size()!=0) {
			 structure.setData(list);
			 structure.setStatusCode(HttpStatus.FOUND.value());
			 structure.setTimeStamp(LocalDateTime.now());
			 structure.setMessage("Product details found in database");
		 }else {
			 structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			 structure.setData(null);
			 structure.setTimeStamp(LocalDateTime.now());
			 structure.setMessage("NO Product Details found in database");
		 }
		return structure;
	}

	public ResponseStructure<ProductEntity> getDataById(Long id){
		ProductEntity dataById = dao.getProductDataById(id);
		 ResponseStructure<ProductEntity> structure = new ResponseStructure<>();
		 structure.setData(dataById);
		 structure.setStatusCode(HttpStatus.OK.value());
		 structure.setTimeStamp(LocalDateTime.now());
		 structure.setMessage(HttpStatus.OK.name());
		return structure;
	}
	
	public ProductEntity deleteProductById(Long id) {
		return dao.deleteProductDataById(id);
	}
	
//	Custom Methods
	
    //getCustomerByName
	public List<ProductEntity> getProductByName(String productName) {
		return dao.getproductByName(productName);
		
	}
	
	//validateProduct
	public List<ProductEntity> validateProduct(String productName, int volume, float marketCapital, float creditRating) {
		return dao.sortProduct(productName, volume, marketCapital,creditRating);
		
	}
}
