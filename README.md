[![Build Status](https://travis-ci.com/jccorreacouto/desafioGLB.svg?branch=master)](https://travis-ci.com/jccorreacouto/desafioGLB)
[![Coverage Status](https://coveralls.io/repos/github/jccorreacouto/desafioGLB/badge.svg?branch=master)](https://coveralls.io/github/jccorreacouto/desafioGLB?branch=master)

## Dois Desafios Técnicos

### 1 - Decode URL

Dada uma *URL*, desenvolva um programa que indique se a URL é válida ou não e, caso seja válida, retorne as suas partes constituintes.

**Cenários de Teste**

> 1. Entrada: `https://globoesporte.globo.com/`
> 2. Saída
>   -  protocolo: https
>   -  host: globoesporte
>   - domínio: globo.com

> 1. Entrada: `http://www.google.com/mail/user=fulano`
> 2. Saída
>   - protocolo: http 
>   - host: www 
>   - domínio: google.com 
>   - path: mail 
>   - parâmetros: user=fulano

> 1. Entrada: `ssh://fulano%senha@git.com/`
> 2. Saída 
>   - protocolo: ssh 
>   - usuário: fulano 
>   - senha: senha 
>   - dominio: git.com

````
* Solução: API Spring Boot
    - Para iniciar a aplicação, executar na raiz do projeto o comando: "mvn spring-boot:run" ou atravez da classe DesafioApplication.
* Endpoint com método POST:
    - URL de acesso:
        http://localhost:8080/url/decode
    - No REQUEST, passar no body:
        {
           "url": "http://www.google.com/mail/user=fulano"
        }
    - No request, informar no Header: 
        KEY: Content-Type
        VALUE: application/json
    - Tendo como RESPONSE
        {
            "protocolo": "http",
            "host": "www",
            "dominio": "google.com",
            "path": "mail",
            "parametro": "user=fulano"
        }
````

### 2 - Happy Number

Para saber se um número é feliz, você deve obter o quadrado de cada dígito deste número, em seguida você faz a soma desses resultados. A seguir o mesmo procedimento deve ser feito com o valor resultante desta soma. Se ao repetir o procedimento diversas vezes obtivermos o valor 1, o número inicial é considerado feliz.

Tomamos o 7, que é um **número feliz**:

- 7² = 49
- 4² + 9² = 97
- 9² + 7² = 130
- 1² + 3² + 0² = 10
- 1² + 0² = 1

Podemos observar nesse exemplo que os números **49, 97, 130 e 10** também são felizes. Existem infinitos números felizes.

E um número triste? Como sabemos que um número não será feliz?

Desenvolva um programa que determine se um número é feliz ou triste.

````
* Solução: API Spring Boot
    - Para iniciar a aplicação, executar na raiz do projeto o comando: "mvn spring-boot:run" ou atravez da classe DesafioApplication.
* Endpoint com método POST:
    - URL de acesso:
        http://localhost:8080/numero/emocao
    - No request, passar no body:
        {
           "numero": 7
        }
    - No request, informar no Header: 
        KEY: Content-Type
        VALUE: application/json
    - Tendo como response:
        {
            "resultado": "NÚMERO 7 É FELIZ! =)"
        }
````
