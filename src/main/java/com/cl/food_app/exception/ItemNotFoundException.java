package com.cl.food_app.exception;

public class ItemNotFoundException extends RuntimeException {
	
String message="Item is not available now";
	
	@Override
	public String getMessage() {
		return message;
	}

}
