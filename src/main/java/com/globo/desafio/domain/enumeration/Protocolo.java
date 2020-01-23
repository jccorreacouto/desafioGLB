package com.globo.desafio.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Protocolo {

    HTTP("http"),
    HTTPS("https"),
    SSH("ssh");

    private String descricao;
}
