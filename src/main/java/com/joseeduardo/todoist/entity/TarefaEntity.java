package com.joseeduardo.todoist.entity;

import java.io.Serializable;

import com.joseeduardo.todoist.entity.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_tarefas")
@EqualsAndHashCode
@Builder
public class TarefaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tarefa_id;
	@Column(name = "titulo")
	private String tarefa_titulo;
	@Column(name = "descrição")
	private String tarefa_descrição;
	@Column(name = "status")
	private Status tarefa_status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	public TarefaEntity() {

	}

	public TarefaEntity(Long id, String tarefa_titulo, String tarefa_descrição, Status status, UsuarioEntity usuario) {
		this.tarefa_id = id;
		this.tarefa_titulo = tarefa_titulo;
		this.tarefa_descrição = tarefa_descrição;
		this.usuario = usuario;
		this.tarefa_status = status;
	}

	public Long getTarefa_id() {
		return this.tarefa_id;
	}

	public void setTarefa_id(Long tarefa_id) {
		this.tarefa_id = tarefa_id;
	}

	public String getTarefa_titulo() {
		return this.tarefa_titulo;
	}

	public void setTarefa_titulo(String tarefa_titulo) {
		this.tarefa_titulo = tarefa_titulo;
	}

	public String getTarefa_descrição() {
		return this.tarefa_descrição;
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

	public Status getTarefa_status() {
		return tarefa_status;
	}

	public void setTarefa_status(Status tarefa_status) {
		this.tarefa_status = tarefa_status;
	}
	

}