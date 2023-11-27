package com.travash.nigrani.ExceptionHandler;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserNotFoundException(String massage) {
		super(massage);
		// TODO Auto-generated constructor stub
}
}
