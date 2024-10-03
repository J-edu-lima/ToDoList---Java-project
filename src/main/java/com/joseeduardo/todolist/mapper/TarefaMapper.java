package com.joseeduardo.todolist.mapper;

import com.joseeduardo.todolist.entity.TarefaEntity;
import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.entity.enums.Status;
import com.joseeduardo.todolist.model.CriarTarefaEntradaDTO;

public class TarefaMapper {

	private TarefaMapper(TarefaEntity tarefa) {
	}

	public static TarefaEntity paraEntidade(CriarTarefaEntradaDTO dto, UsuarioEntity user) {
		
		return new TarefaEntity(dto.getId(), dto.getTitulo(), dto.getDescrição(), Status.CRIADA, user);
	}
}