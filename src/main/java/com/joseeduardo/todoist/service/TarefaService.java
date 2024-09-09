package com.joseeduardo.todoist.service;

import java.util.List;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.model.CriarTarefaEntradaDTO;

public interface TarefaService {
	void criar(CriarTarefaEntradaDTO criarTarefaEntradaDTO, Long id);

	void excluirPorID(Long id);

	List<TarefaEntity> buscarTodos();
}