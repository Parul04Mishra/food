package com.cl.food_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cl.food_app.util.ResponseStructure;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception){
    	ResponseStructure<String> structure=new ResponseStructure<String>();
    	structure.setMessage(exception.getMessage());
    	structure.setStatus(HttpStatus.NOT_FOUND.value());
    	structure.setT("No Such Id Found");
    	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productNotFoundException(OrderNotFoundException found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(found.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("Product not available now");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> itemNotFound(ItemNotFoundException found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(found.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("Item is not present in stock");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MenuNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> menuNotFound(MenuNotFoundException found){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(found.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setT("Menu is not available");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}