package com.joseeduardo.todolist.security.dto;

import jakarta.annotation.Nullable;

public record LoginEntradaDto(@Nullable String nome, @Nullable String senha) {

}
