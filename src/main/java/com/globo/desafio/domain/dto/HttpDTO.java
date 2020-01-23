package com.globo.desafio.domain.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HttpDTO {

    private String protocolo;
    private String host;
    private String dominio;
    private String path;
    private String parametro;

}
