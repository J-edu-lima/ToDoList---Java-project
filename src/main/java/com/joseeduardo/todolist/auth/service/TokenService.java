package com.joseeduardo.todolist.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.joseeduardo.todolist.entity.UsuarioEntity;

@Service
public class TokenService {

	private String secret = "senha";

	public String generateToken(UsuarioEntity usuarioEntity) {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		String token = JWT.create().withIssuer("auth").withSubject(usuarioEntity.getNome())
				.withClaim("id", usuarioEntity.getId())
				.withExpiresAt(LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("-03:00"))).sign(algorithm);

		return token;
	}

	public String validarToken(String token) {
		Algorithm algorithm = Algorithm.HMAC256(secret);

		return JWT.require(algorithm).withIssuer("auth").build().verify(token).getSubject();
	}
}