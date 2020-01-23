package com.globo.desafio.utils;

import com.globo.desafio.domain.enumeration.Mensagem;
import com.globo.desafio.util.UtilsNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsNumberTest {

    @Test
    public void testCalcularQuadrado() throws Exception {
        Assert.assertNotNull(UtilsNumber.calcularQuadrado(7L));
    }

    @Test
    public void testCalcularQuadradoException() {
        try {
            UtilsNumber.calcularQuadrado(null);
        } catch (Exception e) {
            Assert.assertEquals(Mensagem.ERRO_NUMERO_NULO.getDescricao(), e.getMessage());
        }
    }
}
