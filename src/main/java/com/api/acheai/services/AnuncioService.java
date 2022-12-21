package com.api.acheai.services;


import com.api.acheai.models.Anuncio;
import com.api.acheai.repositories.AnuncioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {

    final AnuncioRepository anuncioRepository;

    public AnuncioService(AnuncioRepository anuncioRepository){
        this.anuncioRepository = anuncioRepository;
    }

    public List<Anuncio> getAllAnuncios(){
        return anuncioRepository.findAll();
    }

    public Anuncio saveAnuncio(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }
}
