package com.joseeduardo.todoist.model;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.entity.enums.Status;

import lombok.Builder;

@Builder
public class CriarTarefaEntradaDTO {

	private Long id;

	private String titulo;

	private String descrição;

	private Status status;

	private UsuarioEntity usuario;

	public CriarTarefaEntradaDTO(Long id, String titulo, String descrição, Status status) {
		this.id = id;
		this.titulo = titulo;
		this.descrição = descrição;
		this.status = status;
	}

	public CriarTarefaEntradaDTO(TarefaEntity x) {

		this.id = x.getId();
		this.titulo = x.getTitulo();
		this.descrição = x.getDescrição();
		this.status = x.getStatus();
		this.usuario = x.getUsuario();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
