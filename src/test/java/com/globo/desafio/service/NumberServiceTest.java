package com.globo.desafio.service;

import com.globo.desafio.request.NumberRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NumberServiceTest {

    @Autowired
    private NumberService service;

    @Test
    public void testCalcularEmocional() throws Exception {
        NumberRequest request = NumberRequest.builder().numero(7L).build();
        Assert.assertNotNull(this.service.calcularEmocional(request));
    }
}
