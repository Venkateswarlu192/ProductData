package com.product.application.dto;

import com.product.application.entity.ProductEntity;
import lombok.Data;


@Data
public class ProductDto {

	private String productName;
	private int volume;
	private float marketCapital;
	private float creditRating;
	
	ProductDto(){
		
	}
	
	public ProductDto(ProductEntity entity) {
		this.productName = productName;
		this.volume = volume;
		this.marketCapital = marketCapital;
		this.creditRating = creditRating;
	}
	
	
}
