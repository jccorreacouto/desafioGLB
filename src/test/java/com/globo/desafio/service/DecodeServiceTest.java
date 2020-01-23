package com.globo.desafio.service;

import com.globo.desafio.request.DecodeRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DecodeServiceTest {

    @Autowired
    private DecodeService service;

    @Test
    public void testDecodeUrlHttp() throws Exception {
        DecodeRequest request = DecodeRequest.builder().url("https://globoesporte.globo.com/").build();
        Object obj = this.service.decodeUrl(request);
        Assert.assertNotNull(obj);
    }

    @Test
    public void testDecodeUrlSsh() throws Exception {
        DecodeRequest request = DecodeRequest.builder().url("ssh://fulano:senha@git.com/").build();
        Object obj = this.service.decodeUrl(request);
        Assert.assertNotNull(obj);
    }

    @Test
    public void testDecodeUrlNull() throws Exception {
        DecodeRequest request = DecodeRequest.builder().url("ftp://fulano:senha@git.com/").build();
        Object obj = this.service.decodeUrl(request);
        Assert.assertNull(obj);
    }
}
