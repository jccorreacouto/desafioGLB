package com.globo.desafio.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Mensagem {

    ERRO_URL_SSH_INVALIDA("URL SSH inválida."),
    ERRO_URL_HTTP_HTTPS_INVALIDA("URL HTTP/HTTPS inválida."),
    ERRO_URL_INVALIDA("URL Inválida"),
    ERRO_NUMERO_NULO("Número não informado.");

    private String descricao;
}
