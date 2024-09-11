package com.joseeduardo.todoist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.mapper.UsuarioMapper;
import com.joseeduardo.todoist.model.CriarUsuarioEntradaDTO;
import com.joseeduardo.todoist.repository.UsuarioRepository;
import com.joseeduardo.todoist.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void criar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO) {
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
}