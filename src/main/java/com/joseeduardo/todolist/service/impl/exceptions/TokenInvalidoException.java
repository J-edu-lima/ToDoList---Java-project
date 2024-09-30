package com.joseeduardo.todolist.service.impl.exceptions;

public class TokenInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TokenInvalidoException() {
		super("TOKEN INVÁLIDO");
		
	}

}
