package com.joseeduardo.todoist.service.impl;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.mapper.UsuarioMapper;
import com.joseeduardo.todoist.model.CriarUsuarioEntradaDTO;
import com.joseeduardo.todoist.repository.UsuarioRepository;
import com.joseeduardo.todoist.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void criar(CriarUsuarioEntradaDTO criarUsuarioEntradaDTO) {
        UsuarioEntity usuarioEntity = UsuarioMapper.paraEntidade(criarUsuarioEntradaDTO);

        usuarioRepository.save(usuarioEntity);
    }
}