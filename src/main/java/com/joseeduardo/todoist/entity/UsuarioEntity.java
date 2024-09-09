package com.joseeduardo.todoist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<TarefaEntity> tarefas = new ArrayList<>();

	public UsuarioEntity() {

	}
	public UsuarioEntity(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public Long getId(Long id) {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TarefaEntity> getTarefas() {
		return tarefas;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}