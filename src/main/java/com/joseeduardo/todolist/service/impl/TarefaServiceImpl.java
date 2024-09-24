package com.joseeduardo.todolist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.joseeduardo.todolist.entity.TarefaEntity;
import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.entity.enums.Status;
import com.joseeduardo.todolist.mapper.TarefaMapper;
import com.joseeduardo.todolist.model.CriarTarefaEntradaDTO;
import com.joseeduardo.todolist.repository.TarefaRepository;
import com.joseeduardo.todolist.service.TarefaService;
import com.joseeduardo.todolist.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class TarefaServiceImpl implements TarefaService {

	private TarefaRepository tarefaRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	public TarefaServiceImpl(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	@Override
	public void criar(CriarTarefaEntradaDTO criarTarefaEntradaDTO, @PathVariable Long id) {
		if (validarUsuario(id) == true) {
			UsuarioEntity user = usuarioService.buscar(id);
			TarefaEntity tarefaEntity = TarefaMapper.paraEntidade(criarTarefaEntradaDTO, user);

			tarefaRepository.save(tarefaEntity);
		} else
			throw new RuntimeException("Usuario Inválido");
	}

	@Override
	public void excluir(Long id) {
		Optional<TarefaEntity> tarefa = tarefaRepository.findById(id);
		if (validarUsuario(tarefa.get().getUsuario().getId()) == true) {

			tarefaRepository.deleteById(id);
		} else
			throw new RuntimeException("Usuario Inválido");
	}

	@Override
	public List<TarefaEntity> buscarTodos() {

		return tarefaRepository.findAll();
	}

	@Override
	public List<TarefaEntity> buscarPorStatus(Status status) {

		return tarefaRepository.findByStatus(status);
	}

	@Override
	public TarefaEntity buscar(Long id) {
		Optional<TarefaEntity> tarefa = tarefaRepository.findById(id);

		return tarefa.orElseThrow();
	}

	@Override
	@Transactional
	public TarefaEntity atualizar(TarefaEntity novaTarefa, TarefaEntity tarefa) {
		if (validarUsuario(tarefa.getUsuario().getId()) == true) {
			tarefa.setStatus((novaTarefa.getStatus()));

			return tarefaRepository.save(tarefa);
		} else
			throw new RuntimeException("Usuario Inválido");
	}

	@Override
	public boolean validarUsuario(Long id) {
		UsuarioEntity usuario = usuarioService.buscar(id);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if (usuario.getNome().equals(name)) {

			return true;
		} else
			return false;
	}
}