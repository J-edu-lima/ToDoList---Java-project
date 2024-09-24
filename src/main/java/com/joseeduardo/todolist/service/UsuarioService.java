package com.joseeduardo.todolist.service;

import java.util.List;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.model.CriarUsuarioEntradaDTO;

public interface UsuarioService {
	
    void registrar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO);
    void excluir(Long id);
	List<UsuarioEntity> buscarTodos();
	UsuarioEntity buscar(Long id);
}