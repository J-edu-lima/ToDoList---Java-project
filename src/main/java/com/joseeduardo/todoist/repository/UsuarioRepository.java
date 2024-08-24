package com.joseeduardo.todoist.repository;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}