package com.example.pruebavalidaciones.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class passwordHashingTest {

    public static void main(String[] args) {
        String password = "123456";

        // Crea el codificador de contraseñas usando BCrypt
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Hashea la contraseña
        String hashedPassword = passwordEncoder.encode(password);

        // Imprime el hash generado
        System.out.println("Contraseña original: " + password);
        System.out.println("Contraseña hasheada: " + hashedPassword);

        // Verifica si la contraseña coincide con el hash generado (esto es solo para demostración)
        boolean matches = passwordEncoder.matches(password, hashedPassword);
        System.out.println("¿Contraseña coincide con el hash? " + matches);
    }
}