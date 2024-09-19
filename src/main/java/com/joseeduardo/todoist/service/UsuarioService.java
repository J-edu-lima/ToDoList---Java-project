package com.joseeduardo.todoist.service;

import java.util.List;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.model.CriarUsuarioEntradaDTO;

public interface UsuarioService {
	
    void criar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO);
	List<UsuarioEntity> buscarTodos();
	UsuarioEntity buscar(Long id);
}