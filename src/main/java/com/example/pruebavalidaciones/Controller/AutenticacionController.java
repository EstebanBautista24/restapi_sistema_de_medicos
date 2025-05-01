package com.example.pruebavalidaciones.Controller;

import com.example.pruebavalidaciones.Model.Usuario;
import com.example.pruebavalidaciones.Service.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@SecurityRequirement(name = "bearer-key")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid Usuario usuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuario.getUsuario(),usuario.getContraseña());
        Authentication usuarioAutenticado =  authenticationManager.authenticate(authToken);
        String token = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(token);
    }
}
