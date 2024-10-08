package com.joseeduardo.todolist.service;

import java.util.List;

import com.joseeduardo.todolist.entity.TarefaEntity;
import com.joseeduardo.todolist.entity.enums.Status;
import com.joseeduardo.todolist.model.CriarTarefaEntradaDTO;

public interface TarefaService {
	
	void criar(CriarTarefaEntradaDTO criarTarefaEntradaDTO, Long id);
	void excluir(Long id);
	List<TarefaEntity> buscarTodos();
	TarefaEntity buscar(Long id);
	TarefaEntity atualizar(TarefaEntity novaTarefa, TarefaEntity tarefa);
	List<TarefaEntity> buscarPorStatus(Status status);
	boolean validarUsuario(Long id);

}