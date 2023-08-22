package com.product.application.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.application.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

//	Custom Methods
	public List<ProductEntity> findByProductName(String productName);
	
	@Query("select c from ProductEntity c where c.productName=:pname AND c.volume=:volume AND c.marketCapital=:marketCapital AND c.creditRating=:creditRating")
	public List<ProductEntity> validateProductdetails( @Param("pname") String productName, @Param("volume") int volume, @Param("marketCapital") float marketCapital, @Param("creditRating") float creditRating);
}
