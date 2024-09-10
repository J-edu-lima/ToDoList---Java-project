package com.joseeduardo.todoist.model;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.entity.enums.Status;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CriarTarefaEntradaDTO {

	private Long id;
	private String tarefa_titulo;
	private String tarefa_descrição;
	private Status status;

	private UsuarioEntity usuario;

	public CriarTarefaEntradaDTO(Long id, String tarefa_titulo, String tarefa_descrição, Status status) {
		this.id = id;
		this.tarefa_titulo = tarefa_titulo;
		this.tarefa_descrição = tarefa_descrição;
		this.status = status;
	}

	public CriarTarefaEntradaDTO(TarefaEntity x) {
		this.id = x.getId();
		this.tarefa_titulo = x.getTitulo();
		this.tarefa_descrição = x.getDescrição();
		this.status = x.getStatus();
	}

	public String getTarefa_titulo() {
		return tarefa_titulo;
	}

	public void setTarefa_titulo(String tarefa_titulo) {
		this.tarefa_titulo = tarefa_titulo;
	}

	public String getTarefa_descrição() {
		return tarefa_descrição;
	}

	public void setTarefa_descrição(String tarefa_descrição) {
		this.tarefa_descrição = tarefa_descrição;
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
