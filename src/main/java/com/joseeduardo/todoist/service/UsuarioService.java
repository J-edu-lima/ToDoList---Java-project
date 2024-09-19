package com.joseeduardo.todoist.service;

import java.util.List;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.model.CriarUsuarioEntradaDTO;

public interface UsuarioService {
	
    void criar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO);
    void excluir(Long id);
	List<UsuarioEntity> buscarTodos();
	UsuarioEntity buscar(Long id);
}