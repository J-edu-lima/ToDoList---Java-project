package com.joseeduardo.todoist.mapper;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.model.CriarUsuarioEntradaDTO;

public class UsuarioMapper {

	private UsuarioMapper(UsuarioEntity user) {
	}

	public static UsuarioEntity paraEntidade(CriarUsuarioEntradaDTO dto) {
		return new UsuarioEntity(dto.getNome(), dto.getSenha());
	}
}