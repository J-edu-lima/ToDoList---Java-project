package com.joseeduardo.todolist.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseeduardo.todolist.auth.service.AuthorizationService;
import com.joseeduardo.todolist.security.dto.LoginDto;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	AuthorizationService authorizationService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {

		return authorizationService.login(loginDto);
	}
}