package com.joseeduardo.todolist.security.dto;

import jakarta.annotation.Nullable;

public record LoginDto(@Nullable String nome, @Nullable String senha) {

}
