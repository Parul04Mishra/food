package com.cl.food_app.exception;

public class OrderNotFoundException  extends RuntimeException{
	
String message="This order is not there";
	
	public String getMessage() {
		return message;
	}

}
