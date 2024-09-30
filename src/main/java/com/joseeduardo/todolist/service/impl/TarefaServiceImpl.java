package com.joseeduardo.todolist.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.joseeduardo.todolist.entity.TarefaEntity;
import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.entity.enums.Status;
import com.joseeduardo.todolist.mapper.TarefaMapper;
import com.joseeduardo.todolist.model.CriarTarefaEntradaDTO;
import com.joseeduardo.todolist.repository.TarefaRepository;
import com.joseeduardo.todolist.service.TarefaService;
import com.joseeduardo.todolist.service.UsuarioService;
import com.joseeduardo.todolist.service.impl.exceptions.DadosIncompativeisException;
import com.joseeduardo.todolist.service.impl.exceptions.IdInvalidoException;
import com.joseeduardo.todolist.service.impl.exceptions.ObjetoNaoEncontradoException;

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
		try {
			if (validarUsuario(id)) {
				UsuarioEntity user = usuarioService.buscar(id);
				TarefaEntity tarefaEntity = TarefaMapper.paraEntidade(criarTarefaEntradaDTO, user);

				tarefaRepository.save(tarefaEntity);
			} else {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			throw new IdInvalidoException();
		}
	}

	@Override
	public void excluir(Long id) {
		try {
			Optional<TarefaEntity> tarefa = tarefaRepository.findById(id);
			if (validarUsuario(tarefa.get().getUsuario().getId())) {

				tarefaRepository.deleteById(id);
			} else {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			throw new ObjetoNaoEncontradoException(id);
		}
	}

	@Override
	public List<TarefaEntity> buscarTodos() {

		return tarefaRepository.findAll();
	}

	@Override
	public List<TarefaEntity> buscarPorStatus(Status status) {
		try {

			return tarefaRepository.findByStatus(status);
		} catch (NoSuchElementException e) {
			throw new ObjetoNaoEncontradoException(status);
		} catch (MethodArgumentTypeMismatchException e) {
			throw new ObjetoNaoEncontradoException(status);
		}
	}

	@Override
	public TarefaEntity buscar(Long id) {
		try {
			Optional<TarefaEntity> tarefa = tarefaRepository.findById(id);

			return tarefa.orElseThrow();
		} catch (NoSuchElementException e) {
			throw new ObjetoNaoEncontradoException(id);
		}
	}

	@Override
	@Transactional
	public TarefaEntity atualizar(TarefaEntity novaTarefa, TarefaEntity tarefa) {
		try {
			if (validarUsuario(tarefa.getUsuario().getId())) {
				tarefa.setStatus((novaTarefa.getStatus()));

				return tarefaRepository.save(tarefa);
			} else {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			throw new IdInvalidoException();
		} catch (HttpMessageNotReadableException e) {
			throw new DadosIncompativeisException();
		}
	}

	@Override
	public boolean validarUsuario(Long id) {
		UsuarioEntity usuario = usuarioService.buscar(id);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		return usuario.getNome().equals(name);
	}
}