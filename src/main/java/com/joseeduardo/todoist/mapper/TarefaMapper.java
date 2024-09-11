package com.joseeduardo.todoist.mapper;

import com.joseeduardo.todoist.entity.TarefaEntity;
import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.entity.enums.Status;
import com.joseeduardo.todoist.model.CriarTarefaEntradaDTO;

public class TarefaMapper {

	private TarefaMapper(TarefaEntity tarefa) {
	}

	public static TarefaEntity paraEntidade(CriarTarefaEntradaDTO dto, UsuarioEntity user) {

		return new TarefaEntity(dto.getId(), dto.getTarefa_titulo(), dto.getTarefa_descrição(), Status.INICIADA, user);
	}
}