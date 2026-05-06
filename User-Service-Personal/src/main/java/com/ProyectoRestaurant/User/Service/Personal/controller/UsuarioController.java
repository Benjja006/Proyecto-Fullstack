package com.ProyectoRestaurant.User.Service.Personal.controller;
import com.ProyectoRestaurant.User.Service.Personal.model.Usuario;
import com.ProyectoRestaurant.User.Service.Personal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/rol/{rol}")
    public List<Usuario> obtenerPorRol(@PathVariable String rol) {
        return usuarioService.listarPorRol(rol);
    }
}