package com.joseeduardo.todoist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.mapper.TarefaMapper;
import com.joseeduardo.todoist.model.CriarTarefaEntradaDTO;
import com.joseeduardo.todoist.repository.TarefaRepository;
import com.joseeduardo.todoist.service.TarefaService;
import com.joseeduardo.todoist.service.UsuarioService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	public TarefaServiceImpl(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	@Override
	public void criar(CriarTarefaEntradaDTO criarTarefaEntradaDTO, @PathVariable Long id) {
		UsuarioEntity user = usuarioService.buscarPorID(id);
		TarefaEntity tarefaEntity = TarefaMapper.paraEntidade(criarTarefaEntradaDTO, user);
		tarefaRepository.save(tarefaEntity);
	}

	@Override
	public void excluir(Long id) {
		tarefaRepository.deleteById(id);

	}

}