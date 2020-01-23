package com.globo.desafio.mapper;

import com.globo.desafio.domain.dto.SshDTO;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.function.Function;

@Component
public class SshMapper implements Function<URI, SshDTO> {

    @Override
    public SshDTO apply(URI uri) {
        String[] user = uri.getUserInfo().split(":");
        return SshDTO.builder()
                .protocolo(uri.getScheme())
                .usuario(user[0])
                .senha(user[1])
                .dominio(uri.getHost())
                .build();
    }
}
