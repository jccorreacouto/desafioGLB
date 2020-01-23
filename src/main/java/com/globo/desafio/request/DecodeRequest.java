package com.globo.desafio.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DecodeRequest {

    private String url;
}
