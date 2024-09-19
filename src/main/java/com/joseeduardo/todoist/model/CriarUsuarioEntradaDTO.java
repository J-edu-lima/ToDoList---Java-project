package com.joseeduardo.todoist.model;

import com.joseeduardo.todoist.entity.UsuarioEntity;

public class CriarUsuarioEntradaDTO {

	private String nome;
	private String senha;

	public CriarUsuarioEntradaDTO() {

	}

	public CriarUsuarioEntradaDTO(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public CriarUsuarioEntradaDTO(UsuarioEntity user) {
		this.nome = user.getNome();
		this.senha = user.getSenha();
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

}
