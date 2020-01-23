package com.globo.desafio.web;

import com.globo.desafio.request.DecodeRequest;
import com.globo.desafio.request.NumberRequest;
import com.globo.desafio.response.NumberResponse;
import org.springframework.http.ResponseEntity;

public interface DesafioApi {

    ResponseEntity<?> decodeUrl(DecodeRequest request) throws Exception;

    ResponseEntity<NumberResponse> calcularEmocional(NumberRequest request) throws Exception;
}
