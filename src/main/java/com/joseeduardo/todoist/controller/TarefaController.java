package com.joseeduardo.todoist.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.enums.Status;
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

	@PostMapping("/criar/{id}")
	public ResponseEntity<Void> criar(@RequestBody CriarTarefaEntradaDTO criarTarefaEntradaDTO,
			@PathVariable("id") Long id) {
		tarefaService.criar(criarTarefaEntradaDTO, id);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> exlcuirPorID(@PathVariable("id") Long id) {
		tarefaService.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping
	public ResponseEntity<List<CriarTarefaEntradaDTO>> buscarTodos() {
		List<TarefaEntity> tarefas = tarefaService.buscarTodos();
		List<CriarTarefaEntradaDTO> tarefasEntradaDTO = tarefas.stream().map(x -> new CriarTarefaEntradaDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(tarefasEntradaDTO);
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<List<CriarTarefaEntradaDTO>> buscarStatus(@PathVariable Status status) {
		List<TarefaEntity> tarefas = tarefaService.buscarPorStatus(status);
		List<CriarTarefaEntradaDTO> tarefasEntradaDTO = tarefas.stream().map(x -> new CriarTarefaEntradaDTO(x))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(tarefasEntradaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CriarTarefaEntradaDTO> buscar(@PathVariable("id") Long id) {
		TarefaEntity tarefa = tarefaService.buscar(id);
		return ResponseEntity.ok().body(new CriarTarefaEntradaDTO(tarefa));
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Void> atualizarStatus(@RequestBody TarefaEntity novoStatus, @PathVariable Long id) {
		TarefaEntity tarefa = tarefaService.buscar(id);
		tarefaService.atualizar(novoStatus, tarefa);
		return ResponseEntity.noContent().build();
	}

}