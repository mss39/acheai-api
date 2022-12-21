package com.api.acheai.controllers;

import com.api.acheai.models.Anuncio;
import com.api.acheai.services.AnuncioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/anuncios")
public class AnuncioController {

    final AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService){
        this.anuncioService = anuncioService;
    }

    @GetMapping("")
    public ResponseEntity<List<Anuncio>> getAllAnuncios(){
        return ResponseEntity.status(HttpStatus.OK).body(anuncioService.getAllAnuncios());
    }

    @PostMapping("")
    public ResponseEntity<Anuncio> saveAnuncio(@RequestBody Anuncio anuncio){
        return ResponseEntity.status(HttpStatus.CREATED).body(anuncioService.saveAnuncio(anuncio));
    }
}
