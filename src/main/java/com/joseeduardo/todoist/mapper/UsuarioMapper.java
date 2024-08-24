package com.joseeduardo.todoist.mapper;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.model.CriarUsuarioEntradaDTO;

public class UsuarioMapper {

    private UsuarioMapper() {}

    public static UsuarioEntity paraEntidade(CriarUsuarioEntradaDTO dto) {
        return UsuarioEntity.builder()
                .nome(dto.getNome())
                .senha(dto.getSenha())
                .build();
    }
}