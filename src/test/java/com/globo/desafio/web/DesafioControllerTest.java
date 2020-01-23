package com.globo.desafio.web;

import com.globo.desafio.request.DecodeRequest;
import com.globo.desafio.request.NumberRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DesafioControllerTest {

    @Autowired
    private DesafioController controller;

    @Test
    public void testAccessMethodDecoder() throws Exception {
        DecodeRequest request = DecodeRequest.builder().url("https://globoesporte.globo.com/").build();
        this.controller.decodeUrl(request);
    }

    @Test
    public void testAccessMethodCalcularEmocional() throws Exception {
        NumberRequest request = NumberRequest.builder().numero(7L).build();
        this.controller.calcularEmocional(request);
    }

}
