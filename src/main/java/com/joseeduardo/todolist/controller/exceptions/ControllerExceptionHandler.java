package com.joseeduardo.todolist.controller.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.joseeduardo.todolist.service.impl.exceptions.DadosIncompativeisException;
import com.joseeduardo.todolist.service.impl.exceptions.IdInvalidoException;
import com.joseeduardo.todolist.service.impl.exceptions.ObjetoNaoEncontradoException;
import com.joseeduardo.todolist.service.impl.exceptions.TokenExpiradoException;
import com.joseeduardo.todolist.service.impl.exceptions.TokenInvalidoException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {
		String erro = "OBJETO NÃO ENCONTRADO";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

	@ExceptionHandler(DadosIncompativeisException.class)
	public ResponseEntity<ErroPadrao> dados(DadosIncompativeisException e, HttpServletRequest request) {
		String erro = "DADOS INCORRETOS OU USUARIO REPETIDO";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

	@ExceptionHandler(IdInvalidoException.class)
	public ResponseEntity<ErroPadrao> idInvalido(IdInvalidoException e, HttpServletRequest request) {
		String erro = "ID INVALIDO";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErroPadrao> httpRequest(HttpMessageNotReadableException e, HttpServletRequest request) {
		String erro = "VALOR INSERIDO INVÁLIDO";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErroPadrao> argumentTypeMismatch(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
		String erro = "VALOR INSERIDO INVÁLIDO";
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

	@ExceptionHandler(TokenInvalidoException.class)
	public ResponseEntity<ErroPadrao> tokenInvalido(TokenInvalidoException e, HttpServletRequest request) {
		String erro = "TOKEN INVÁLIDO";
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

	@ExceptionHandler(TokenExpiradoException.class)
	public ResponseEntity<ErroPadrao> tokenInvalido(TokenExpiradoException e, HttpServletRequest request) {
		String erro = "TOKEN EXPIRADO";
		HttpStatus status = HttpStatus.REQUEST_TIMEOUT;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
}
