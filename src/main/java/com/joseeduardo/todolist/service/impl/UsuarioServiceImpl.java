package com.joseeduardo.todolist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
		if (validarUsuario(id) == true) {

			usuarioRepository.deleteById(id);
		} else
			throw new RuntimeException("Usuario Inválido");
	}

	@Override
	public boolean validarUsuario(Long id) {
		UsuarioEntity usuario = buscar(id);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if (usuario.getNome().equals(name)) {

			return true;
		} else
			return false;
	}
}