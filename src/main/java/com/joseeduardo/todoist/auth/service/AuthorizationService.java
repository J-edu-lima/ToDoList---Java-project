package com.joseeduardo.todoist.auth.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.joseeduardo.todoist.dtos.AuthenticationDto;
import com.joseeduardo.todoist.dtos.LoginResponseDto;
import com.joseeduardo.todoist.dtos.RegisterDto;
import com.joseeduardo.todoist.entity.UsuarioEntity;
import com.joseeduardo.todoist.repository.UsuarioRepository;
import com.joseeduardo.todoist.security.TokenService;

import jakarta.validation.Valid;

@Service
public class AuthorizationService implements UserDetailsService{
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

    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDto data){
        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }


    public ResponseEntity<Object> register (@RequestBody RegisterDto registerDto){
        if (this.usuarioRepository.findByNome(registerDto.nome()) != null ) { return ResponseEntity.badRequest().build();
        }
        else {
        String senhaEncriptada = new BCryptPasswordEncoder().encode(registerDto.senha());
        UsuarioEntity novoUsuario = new UsuarioEntity(registerDto.nome(), senhaEncriptada, registerDto.role());
        this.usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}


    


}
