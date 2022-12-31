package com.api.acheai.controllers;


import com.api.acheai.models.Usuario;
import com.api.acheai.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.create(usuario));
    }

    @GetMapping()
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password){

        return usuarioService.validarSenha(login, password);
    }
}
