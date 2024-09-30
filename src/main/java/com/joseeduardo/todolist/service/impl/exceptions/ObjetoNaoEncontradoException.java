package com.joseeduardo.todolist.service.impl.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(Object id) {
		super("OBJETO NÃO ENCONTRADO - ID: " + id);
	}

}
