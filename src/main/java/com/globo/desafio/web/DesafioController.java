package com.globo.desafio.web;

import com.globo.desafio.request.DecodeRequest;
import com.globo.desafio.request.NumberRequest;
import com.globo.desafio.response.NumberResponse;
import com.globo.desafio.service.DecodeService;
import com.globo.desafio.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
class DesafioController implements DesafioApi {

    @Autowired
    private DecodeService decodeService;

    @Autowired
    private NumberService numberService;

    @Override
    @PostMapping("/url/decode")
    public ResponseEntity<?> decodeUrl(@RequestBody DecodeRequest request) throws Exception {
        return ResponseEntity.ok(this.decodeService.decodeUrl(request));
    }

    @Override
    @PostMapping("/numero/emocao")
    public ResponseEntity<NumberResponse> calcularEmocional(@RequestBody NumberRequest request) throws Exception {
        return ResponseEntity.ok(this.numberService.calcularEmocional(request));
    }
}
