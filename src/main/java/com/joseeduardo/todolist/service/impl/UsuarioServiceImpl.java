package com.joseeduardo.todolist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.mapper.UsuarioMapper;
import com.joseeduardo.todolist.model.CriarUsuarioEntradaDTO;
import com.joseeduardo.todolist.repository.UsuarioRepository;
import com.joseeduardo.todolist.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void registrar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO) {
		UsuarioEntity usuarioEntity = UsuarioMapper.paraEntidade(criarUsuarioEntradaDTO);

		usuarioRepository.save(usuarioEntity);
	}

	@Override
	public List<UsuarioEntity> buscarTodos() {

		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioEntity buscar(Long id) {
		Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);

		return usuario.orElseThrow();
	}

	@Override
	public void excluir(Long id) {

		usuarioRepository.deleteById(id);
	}
}