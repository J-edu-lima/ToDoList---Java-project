package com.joseeduardo.todolist.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.model.CriarUsuarioEntradaDTO;
import com.joseeduardo.todolist.service.UsuarioService;

@RestController
@RequestMapping(value = "/v1/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@RequestBody CriarUsuarioEntradaDTO criarUsuarioEntradaDTO) {
		usuarioService.registrar(criarUsuarioEntradaDTO);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		usuarioService.excluir(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping
	public ResponseEntity<List<CriarUsuarioEntradaDTO>> buscarTodos() {
		List<UsuarioEntity> usuarios = usuarioService.buscarTodos();
		List<CriarUsuarioEntradaDTO> usuariosSaidaDto = usuarios.stream().map(x -> new CriarUsuarioEntradaDTO(x))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(usuariosSaidaDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CriarUsuarioEntradaDTO> buscar(@PathVariable("id") Long id) {
		UsuarioEntity usuario = usuarioService.buscar(id);

		return ResponseEntity.ok().body(new CriarUsuarioEntradaDTO(usuario));
	}
}