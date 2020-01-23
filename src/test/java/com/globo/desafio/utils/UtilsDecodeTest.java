package com.globo.desafio.utils;

import com.globo.desafio.domain.enumeration.Mensagem;
import com.globo.desafio.util.UtilsDecode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.net.URI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsDecodeTest {

    @Test
    public void testIsValidUri() {
        String url = "http://www.google.com/mail/user=fulano";
        Assert.assertTrue(UtilsDecode.isValidUri(url));
    }

    @Test
    public void testInvalidUri() {
        String url = "imap://www.google.com/";
        Assert.assertFalse(UtilsDecode.isValidUri(url));
    }

    @Test
    public void testConvertStringToUri() throws MalformedURLException {
        String url = "https://globoesporte.globo.com/";
        URI uri = UtilsDecode.convertStringToUri(url);
        Assert.assertNotNull(uri);
    }

    @Test
    public void testConvertStringToUriException() {
        try {
            URI uri = UtilsDecode.convertStringToUri(null);
        } catch (MalformedURLException e) {
            Assert.assertEquals(Mensagem.ERRO_URL_INVALIDA.getDescricao(), e.getMessage());
        }
    }

    @Test
    public void testIsInvalidUriHttp() {
        String url = "https://globoesporte.globo.com/";
        URI uri = URI.create(url);
        Assert.assertFalse(UtilsDecode.isInvalidUriHttp(uri));
    }

    @Test
    public void testIsInvalidUriSsh() {
        String url = "ssh://fulano:senha@git.com/";
        URI uri = URI.create(url);
        Assert.assertFalse(UtilsDecode.isInvalidUriSsh(uri));
    }
}
