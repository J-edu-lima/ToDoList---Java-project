package com.joseeduardo.todolist.service.impl.exceptions;

public class IdInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public IdInvalidoException() {
		super("NÃO É POSSIVEL CRIAR, ATUALIZAR OU EXCLUIR TAREFAS PARA OUTRO ID");
		
	}

}
