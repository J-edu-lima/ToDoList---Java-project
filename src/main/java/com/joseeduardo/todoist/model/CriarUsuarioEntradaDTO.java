package com.joseeduardo.todoist.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CriarUsuarioEntradaDTO {
    private String nome;
    private String senha;
}
