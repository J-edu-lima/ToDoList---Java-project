package com.joseeduardo.todoist.service;

import java.util.List;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.enums.Status;
import com.joseeduardo.todoist.model.CriarTarefaEntradaDTO;

public interface TarefaService {
	
	void criar(CriarTarefaEntradaDTO criarTarefaEntradaDTO, Long id);
	void excluir(Long id);
	List<TarefaEntity> buscarTodos();
	TarefaEntity buscar(Long id);
	TarefaEntity atualizar(TarefaEntity novaTarefa, TarefaEntity tarefa);
	List<TarefaEntity> buscarPorStatus(Status status);

}