package com.example.pruebavalidaciones.Repository;

import com.example.pruebavalidaciones.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    UserDetails findByUsuario(String username);
}
