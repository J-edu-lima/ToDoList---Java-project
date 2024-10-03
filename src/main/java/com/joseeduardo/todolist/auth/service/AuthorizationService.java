package com.joseeduardo.todolist.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.repository.UsuarioRepository;
import com.joseeduardo.todolist.security.dto.LoginEntradaDto;
import com.joseeduardo.todolist.security.dto.LoginRespostaDto;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TokenService tokenService;

	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		return usuarioRepository.findByNome(nome);
	}

	public ResponseEntity<Object> login(LoginEntradaDto login) {
		authenticationManager = context.getBean(AuthenticationManager.class);
		var usernamePassword = new UsernamePasswordAuthenticationToken(login.nome(), login.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

		return ResponseEntity.ok(new LoginRespostaDto(token));
	}
}