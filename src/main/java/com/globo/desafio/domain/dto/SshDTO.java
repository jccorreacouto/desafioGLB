package com.globo.desafio.domain.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SshDTO {

    private String protocolo;
    private String dominio;
    private String usuario;
    private String senha;
}
