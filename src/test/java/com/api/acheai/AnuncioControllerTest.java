package com.api.acheai;

import com.api.acheai.controllers.AnuncioController;
import com.api.acheai.models.Anuncio;
import com.api.acheai.services.AnuncioService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
public class AnuncioControllerTest {

    @InjectMocks //quando a classe em si, AnuncioController
    private AnuncioController anuncioController;

    @Mock //para usar nas classes dentro de AnuncioController
    private AnuncioService anuncioService;

    @BeforeEach
    void setUp(){
        List<Anuncio> anuncios = new ArrayList<>();
        anuncios.add(new Anuncio());
        anuncios.add(new Anuncio());
        System.out.println(anuncios);
        BDDMockito.when(anuncioService.getAllAnuncios()).thenReturn(anuncios);
    }

    @Test
    @DisplayName("testes get all anuncios")
    public void bookingTestServiceGetAllAnuncios(){
        setUp();
        int expectedSize = 2;
        List<Anuncio> anunciosList = anuncioController.getAllAnuncios().getBody();

        Assertions.assertThat(anunciosList.size()).isEqualTo(expectedSize);
    }

}
//new Anuncio("Chave de carro", "Chave de Gol 2008", null, "Perdido", 200, "Chave"),