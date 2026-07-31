package com.raull.deliciassantana.controllers;

import com.raull.deliciassantana.dtoS.LoginDto;
import com.raull.deliciassantana.dtoS.RegisterDto;
import com.raull.deliciassantana.entitys.FuncionarioEntity;
import com.raull.deliciassantana.repositories.FuncionarioRepository;
import com.raull.deliciassantana.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha()));

        FuncionarioEntity funcionario = funcionarioRepository.findByLogin(dto.getLogin())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        String token = jwtService.gerarToken(funcionario);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<FuncionarioEntity> register(@RequestBody RegisterDto dto) {
        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setNome(dto.getNome());
        funcionario.setLogin(dto.getLogin());
        funcionario.setSenha(passwordEncoder.encode(dto.getSenha()));
        funcionario.setRole(dto.getRole());

        return ResponseEntity.ok(funcionarioRepository.save(funcionario));
    }
}
