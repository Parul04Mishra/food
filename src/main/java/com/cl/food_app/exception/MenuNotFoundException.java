package com.cl.food_app.exception;

public class MenuNotFoundException extends RuntimeException {
String message="This menu is not there";
	
	public String getMessage() {
		return message;
	}

}
