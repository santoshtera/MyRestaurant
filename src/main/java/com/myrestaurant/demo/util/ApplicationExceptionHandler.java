package com.myrestaurant.demo.util;

import java.sql.SQLDataException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyRestuarantException> handleExceptions(Exception e) {
		MyRestuarantException exception = new MyRestuarantException(100, "An Error occured Please try again");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
	}
	

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<MyRestuarantException> handleRuntimeExceptions(Exception e) {
		MyRestuarantException exception = new MyRestuarantException(101, "Error!! Plz check your request and try again");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
	}
	
	
	@ExceptionHandler(SQLDataException.class)
	public ResponseEntity<MyRestuarantException> handleSQLExceptions(Exception e) {
		MyRestuarantException exception = new MyRestuarantException(102, "Database connection error occured");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyRestuarantException> handleProductNotFoundExceptions(Exception e) {
		MyRestuarantException exception = new MyRestuarantException(103, "Product Not Found");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
	}
}
