package com.joseeduardo.todolist.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.entity.enums.UserRole;
import com.joseeduardo.todolist.model.CriarUsuarioEntradaDTO;

public class UsuarioMapper {

	private UsuarioMapper(UsuarioEntity user) {
	}

	public static UsuarioEntity paraEntidade(CriarUsuarioEntradaDTO dto) {
		String senhaEncriptada = new BCryptPasswordEncoder().encode(dto.getSenha());
		
		return new UsuarioEntity(dto.getNome(), senhaEncriptada, UserRole.USER);
	}
}