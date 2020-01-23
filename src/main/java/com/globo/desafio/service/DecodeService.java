package com.globo.desafio.service;

import com.globo.desafio.domain.dto.HttpDTO;
import com.globo.desafio.domain.dto.SshDTO;
import com.globo.desafio.domain.enumeration.Mensagem;
import com.globo.desafio.domain.enumeration.Protocolo;
import com.globo.desafio.mapper.HttpMapper;
import com.globo.desafio.mapper.SshMapper;
import com.globo.desafio.request.DecodeRequest;
import com.globo.desafio.util.UtilsDecode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@Slf4j
public class DecodeService {

    @Autowired
    private HttpMapper httpMapper;

    @Autowired
    private SshMapper sshMapper;

    public Object decodeUrl(DecodeRequest request) throws Exception {
        Object dto = null;
        if(UtilsDecode.isValidUri(request.getUrl())) {
            log.info("url is valid");
            URI uri = UtilsDecode.convertStringToUri(request.getUrl());
            dto = this.popularDados(uri);
        } else {
            log.info("url is invalid");
        }
        return dto;
    }

    private Object popularDados(URI uri) throws Exception {
        Object dto = null;
        switch (Protocolo.valueOf(uri.getScheme().toUpperCase())) {
            case HTTP:
            case HTTPS:
                dto = this.dadosHttp(uri);
                break;
            case SSH:
                dto = this.dadosSsh(uri);
                break;
        }
        return dto;
    }

    private HttpDTO dadosHttp(URI uri) throws Exception {

        if(UtilsDecode.isInvalidUriHttp(uri)) {
            throw new Exception(Mensagem.ERRO_URL_HTTP_HTTPS_INVALIDA.getDescricao());
        }

        return httpMapper.apply(uri);
    }

    private SshDTO dadosSsh(URI uri) throws Exception {

        if(UtilsDecode.isInvalidUriSsh(uri)) {
            throw new Exception(Mensagem.ERRO_URL_SSH_INVALIDA.getDescricao());
        }

        return sshMapper.apply(uri);
    }
}
