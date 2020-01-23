package com.globo.desafio.util;

import com.globo.desafio.domain.enumeration.Mensagem;
import com.globo.desafio.domain.enumeration.Protocolo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class UtilsDecode {

    public static boolean isValidUri(String uriString) {
        String[] protocolos = Arrays.stream(Protocolo.values()).map(Protocolo::getDescricao).toArray(String[]::new);
        UrlValidator urlValidator = new UrlValidator(protocolos);
        return urlValidator.isValid(uriString);
    }

    public static URI convertStringToUri(String uriString) throws MalformedURLException {
        if(Objects.isNull(uriString)) {
            throw new  MalformedURLException(Mensagem.ERRO_URL_INVALIDA.getDescricao());
        }
        URI uri = URI.create(uriString);
        return uri;
    }

    public static boolean isInvalidUriHttp(URI uri) {
        boolean invalid = false;
        if(Objects.isNull(uri.getScheme())) {
            invalid = true;
        }

        if(Objects.isNull(uri.getHost())) {
            invalid = true;
        }

        return invalid;
    }

    public static boolean isInvalidUriSsh(URI uri) {
        boolean invalid = false;
        if(Objects.isNull(uri.getUserInfo())) {
            invalid = true;
        }

        if(Objects.isNull(uri.getScheme())) {
            invalid = true;
        }

        if(Objects.isNull(uri.getHost())) {
            invalid = true;
        }
        return invalid;
    }

}
