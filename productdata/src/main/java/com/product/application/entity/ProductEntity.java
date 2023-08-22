package com.product.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.product.application.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="product_details")
public class ProductEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="pname")
	private String productName;
	
	@Column(name="volume")
	private int volume;
	
	@Column(name="market_capital")
	private float marketCapital;
	
	@Column(name="credit_rating")
	private float creditRating;
	
	public ProductEntity(ProductDto dto) {
		this.id = id;
		this.productName = productName;
		this.volume = volume;
		this.marketCapital = marketCapital;
		this.creditRating = creditRating;
	}

	public ProductEntity(int i, String name, String name2) {
		
	}
	
	
}
