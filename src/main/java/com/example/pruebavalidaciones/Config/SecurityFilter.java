package com.example.pruebavalidaciones.Config;

import com.example.pruebavalidaciones.Model.Usuario;
import com.example.pruebavalidaciones.Repository.IUsuarioRepository;
import com.example.pruebavalidaciones.Service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obtener token del header y validarlo
        String token  = request.getHeader("Authorization"); //nombre de donde llega el token en el header
        if(token!=null){
            token=token.replace("Bearer ","");
            String subject = tokenService.getSubject(token);
            if(subject!=null){
                UserDetails usuario = usuarioRepository.findByUsuario(subject);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());//forzar inicio sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response); //seguir la cadena del filtro
    }
}
