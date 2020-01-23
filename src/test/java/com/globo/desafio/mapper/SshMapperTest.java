package com.globo.desafio.mapper;

import com.globo.desafio.domain.dto.SshDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SshMapperTest {

    @Autowired
    private SshMapper mapper;

    @Test
    public void testSshMapper() {
        URI uri = URI.create("ssh://fulano:senha@git.com/");
        SshDTO dto = mapper.apply(uri);
        SshDTO mock = SshDTO.builder().protocolo("ssh").dominio("git.com").usuario("fulano").senha("senha").build();
        Assert.assertEquals(dto, mock);
    }
}
