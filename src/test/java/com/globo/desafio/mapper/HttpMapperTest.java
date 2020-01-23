package com.globo.desafio.mapper;

import com.globo.desafio.domain.dto.HttpDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HttpMapperTest {

    @Autowired
    private HttpMapper mapper;

    @Test
    public void testHttpMapper() {
        URI uri = URI.create("https://globoesporte.globo.com/");
        HttpDTO dto = mapper.apply(uri);
        HttpDTO mock = HttpDTO.builder().protocolo("https")
                                        .host("globoesporte")
                                        .dominio("globo.com")
                                        .path(null).parametro(null).build();
        Assert.assertEquals(dto, mock);
    }

    @Test
    public void testHttpMapperPathParameter() {
        URI uri = URI.create("http://www.google.com/mail/user=fulano");
        HttpDTO dto = mapper.apply(uri);
        HttpDTO mock = HttpDTO.builder().protocolo("http")
                                        .host("www")
                                        .dominio("google.com")
                                        .path("mail")
                                        .parametro("user=fulano").build();
        Assert.assertEquals(dto, mock);
    }

}
