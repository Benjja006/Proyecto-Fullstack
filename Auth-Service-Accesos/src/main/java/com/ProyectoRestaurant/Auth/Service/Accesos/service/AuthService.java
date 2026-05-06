package com.ProyectoRestaurant.Auth.Service.Accesos.service;

import com.ProyectoRestaurant.Auth.Service.Accesos.model.*;
import com.ProyectoRestaurant.Auth.Service.Accesos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private CredencialRepository credencialRepo;

    @Autowired
    private SesionRepository sesionRepo;

    public String login(String username, String pin) {
        Credencial cred = credencialRepo.findByUsername(username)
                .filter(c -> c.getPinUsuario().equals(pin))
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        String token = UUID.randomUUID().toString();
        cred.setTokenSesion(token);
        credencialRepo.save(cred);

        return token;
    }

    public boolean validateToken(String token) {
        return credencialRepo.findByTokenSesion(token).isPresent();
    }
}
