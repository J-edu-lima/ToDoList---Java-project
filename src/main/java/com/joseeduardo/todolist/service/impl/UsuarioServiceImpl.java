package com.joseeduardo.todolist.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.mapper.UsuarioMapper;
import com.joseeduardo.todolist.model.CriarUsuarioEntradaDTO;
import com.joseeduardo.todolist.repository.UsuarioRepository;
import com.joseeduardo.todolist.service.UsuarioService;
import com.joseeduardo.todolist.service.impl.exceptions.DadosIncompativeisException;
import com.joseeduardo.todolist.service.impl.exceptions.ObjetoNaoEncontradoException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void registrar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO) {
		try {
			UsuarioEntity usuarioEntity = UsuarioMapper.paraEntidade(criarUsuarioEntradaDTO);

			usuarioRepository.save(usuarioEntity);
		} catch (IllegalArgumentException e) {
			throw new DadosIncompativeisException();
		} catch (DataIntegrityViolationException e) {
			throw new DadosIncompativeisException();
		}
	}

	@Override
	public List<UsuarioEntity> buscarTodos() {

		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioEntity buscar(Long id) {
		try {
			Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);

			return usuario.orElseThrow();
		} catch (NoSuchElementException e) {
			throw new ObjetoNaoEncontradoException(id);
		}
	}

	@Override
	public void excluir(Long id) {
		try {
			if (validarUsuario(id)) {

				usuarioRepository.deleteById(id);
			} else {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			throw new ObjetoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DadosIncompativeisException();
		}
	}

	@Override
	public boolean validarUsuario(Long id) {
		UsuarioEntity usuario = buscar(id);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		return usuario.getNome().equals(name);
	}
}