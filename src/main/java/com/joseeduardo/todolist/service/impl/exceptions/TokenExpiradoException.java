package com.joseeduardo.todolist.service.impl.exceptions;

public class TokenExpiradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TokenExpiradoException() {
		super("TOKEN EXPIRADO");
		
	}

}
