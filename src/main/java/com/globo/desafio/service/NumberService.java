package com.globo.desafio.service;

import com.globo.desafio.domain.enumeration.Mensagem;
import com.globo.desafio.request.NumberRequest;
import com.globo.desafio.response.NumberResponse;
import com.globo.desafio.util.UtilsNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
@Slf4j
public class NumberService {

    public NumberResponse calcularEmocional(NumberRequest request) throws Exception {

        if(Objects.isNull(request) || Objects.isNull(request.getNumero())) {
            throw new Exception(Mensagem.ERRO_NUMERO_NULO.getDescricao());
        }

        Long soma = request.getNumero();
        List<Long> somatorios = new ArrayList<>();

        while (soma != 1L) {

            soma = this.somaDosQuadrados(soma);

            if(somatorios.size() > 1 && somatorios.contains(soma)) {
               break;
            }

            somatorios.add(soma);
        }

        return NumberResponse.builder()
                            .resultado(this.determinarEmocao(soma, request.getNumero()))
                            .build();
    }

    private Long somaDosQuadrados(Long numero) throws Exception {
        String numeroString = numero.toString();
        Long soma = 0L;

        Scanner scan = new Scanner(numeroString);
        for (char c : scan.next().toCharArray()) {
            Long n = Long.valueOf(String.valueOf(c));
            Long q = UtilsNumber.calcularQuadrado(n);
            soma += q;
        }

        return soma;
    }

    private String determinarEmocao(Long soma, Long request) {
        String mensagem;
        if(soma.compareTo(1L) == 0) {
            mensagem = new String("NÚMERO " + request + " É FELIZ! =)");
            log.info(mensagem);
        } else {
            mensagem = new String("NÚMERO " + request + " NÃO É FELIZ! =(");
            log.info(mensagem);
        }
        return mensagem;
    }
}
