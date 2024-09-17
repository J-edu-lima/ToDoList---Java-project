package com.joseeduardo.todoist.dtos;

import com.joseeduardo.todoist.security.enums.UserRole;

import jakarta.annotation.Nullable;

public record RegisterDto(@Nullable String nome, @Nullable String senha, @Nullable UserRole role) {

}
