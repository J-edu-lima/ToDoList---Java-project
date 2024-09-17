package com.joseeduardo.todoist.security;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.joseeduardo.todoist.entity.UsuarioEntity;

@Service
public class TokenService {

	private String secret = "senha";

	public String generateToken(UsuarioEntity usuarioEntity) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);

			String token = JWT.create().withIssuer("auth").withSubject(usuarioEntity.getNome()).sign(algorithm);
			return token;

		} catch (JWTCreationException exception) {
			throw new RuntimeException("ERRO NA HORA DE GERAR O TOKEN", exception);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);

			return JWT.require(algorithm).withIssuer("auth").build().verify(token).getSubject();
		}

		catch (JWTVerificationException exception) {
			return "";
		}
	}

}
