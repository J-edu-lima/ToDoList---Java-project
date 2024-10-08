package com.joseeduardo.todolist.model;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.entity.enums.UserRole;

import jakarta.persistence.Column;

public class CriarUsuarioEntradaDTO {
	@Column(unique = true)
	private String nome;

	private String senha;

	private UserRole role;

	public CriarUsuarioEntradaDTO() {

	}

	public CriarUsuarioEntradaDTO(String nome, String senha, UserRole role) {
		this.nome = nome;
		this.senha = senha;
		this.role = role;
	}

	public CriarUsuarioEntradaDTO(UsuarioEntity user) {
		this.nome = user.getNome();
		this.senha = user.getSenha();
		this.role = user.getUserRole();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}