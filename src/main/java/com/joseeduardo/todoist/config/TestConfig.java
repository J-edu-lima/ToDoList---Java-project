package com.joseeduardo.todoist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.repository.UsuarioRepository;
import com.joseeduardo.todoist.security.enums.UserRole;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		String user = "ADM";
		String password = "123";
		String encpass = new BCryptPasswordEncoder().encode(password);
		UserRole role = UserRole.ADMIN;
		
		UsuarioEntity adm = new UsuarioEntity(user, encpass, role);
		usuarioRepository.save(adm);
	}

}
