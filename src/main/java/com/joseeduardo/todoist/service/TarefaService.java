package com.joseeduardo.todoist.service;

import com.joseeduardo.todoist.model.CriarTarefaEntradaDTO;

public interface TarefaService {
	void criar(CriarTarefaEntradaDTO criarTarefaEntradaDTO, Long id);
	void excluir(Long id);


}