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
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descrição")
	private String descrição;
	
	@Column(name = "status")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	public TarefaEntity() {

	}

	public TarefaEntity(Long id, String titulo, String descrição, Status status, UsuarioEntity usuario) {
		this.id = id;
		this.titulo = titulo;
		this.descrição = descrição;
		this.usuario = usuario;
		this.status = status;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return this.descrição;
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
	

}