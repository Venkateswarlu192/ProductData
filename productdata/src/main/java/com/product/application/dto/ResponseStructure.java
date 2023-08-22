package com.product.application.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private Integer statusCode;	
	private T data;	
	private String message;	
	private LocalDateTime timeStamp;
}
