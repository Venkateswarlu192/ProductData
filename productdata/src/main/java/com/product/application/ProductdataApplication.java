package com.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"com.product.Controllor"+ "com.product.Service"})
public class ProductdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductdataApplication.class, args);
		System.out.println("hi");
	}

}
