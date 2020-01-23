package com.globo.desafio.mapper;

import com.globo.desafio.domain.dto.HttpDTO;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@Component
public class HttpMapper implements Function<URI, HttpDTO> {

    @Override
    public HttpDTO apply(URI uri) {
        String[] http = uri.getHost().split("[.]");
        String host = null;
        String dominio = null;
        for(String h : http) {
            if(Objects.isNull(host)) {
                host = h;
            } else if(Objects.isNull(dominio)) {
                dominio = h;
            } else {
                dominio = dominio.concat(".").concat(h);
            }
        }

        String path = null;
        String parametro = null;
        if(Objects.nonNull(uri.getPath())) {
            String[] paths = uri.getPath().split("/");
            if(paths.length > 2) {
                path = paths[1];
                parametro = paths[2];
            }
        }

        return HttpDTO.builder().protocolo(uri.getScheme())
                .host(host)
                .dominio(dominio)
                .path(path)
                .parametro(parametro)
                .build();
    }
}
