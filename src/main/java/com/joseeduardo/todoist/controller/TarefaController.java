package com.joseeduardo.todoist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseeduardo.todoist.model.CriarTarefaEntradaDTO;
import com.joseeduardo.todoist.service.TarefaService;

@RestController
@RequestMapping(value = "/v1/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@Autowired
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	@PostMapping("/{id}")
	public ResponseEntity<Void> criar(@RequestBody CriarTarefaEntradaDTO criarTarefaEntradaDTO,
			@PathVariable("id") Long id) {
		tarefaService.criar(criarTarefaEntradaDTO, id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> exlcuirPorID(@PathVariable("id") Long id) {
		tarefaService.excluirPorID(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}