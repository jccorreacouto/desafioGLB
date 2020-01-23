package com.globo.desafio.util;

import com.globo.desafio.domain.enumeration.Mensagem;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class UtilsNumber {

    public static Long calcularQuadrado(Long numero) throws Exception {
        if(Objects.isNull(numero)) {
            throw new Exception(Mensagem.ERRO_NUMERO_NULO.getDescricao());
        }
        Double aoQuadrado = Math.pow(numero.doubleValue(), 2);
        return aoQuadrado.longValue();
    }
}
