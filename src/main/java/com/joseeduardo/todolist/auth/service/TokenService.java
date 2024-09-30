package com.joseeduardo.todolist.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.joseeduardo.todolist.entity.UsuarioEntity;
import com.joseeduardo.todolist.service.impl.exceptions.TokenExpiradoException;
import com.joseeduardo.todolist.service.impl.exceptions.TokenInvalidoException;

@Service
public class TokenService {

	private String secret = "senha";

	public String generateToken(UsuarioEntity usuarioEntity) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("auth").withSubject(usuarioEntity.getNome())
					.withClaim("id", usuarioEntity.getId())
					.withExpiresAt(LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00")))
					.sign(algorithm);

			return token;
		} catch (JWTCreationException e) {
			throw new TokenExpiradoException();
		}
	}

	public String validarToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);

			return JWT.require(algorithm).withIssuer("auth").build().verify(token).getSubject();
		} catch (JWTVerificationException e) {
			throw new TokenInvalidoException();
		}
	}
}