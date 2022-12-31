package com.api.acheai.services;


import com.api.acheai.models.Anuncio;
import com.api.acheai.repositories.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    AnuncioRepository anuncioRepository;


    public List<Anuncio> getAllAnuncios(){
        System.out.println(anuncioRepository.findAll());
        return anuncioRepository.findAll();
    }

    public Anuncio saveAnuncio(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }
}
