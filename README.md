# Spring-Boot-API-Starter

## Dockerizar a aplicação

```sh
docker build -t api .
```

## Executar 2 instancias da aplicação em containers

Aplicações serão exeutadas nas portas 8080 e 9090

```sh
docker run -p 8080:8080 -t api
docker run -p 9090:8080 -t api
```

## Documentação da API

Acessar o link após subir a aplicação na porta 8080

```url
http://localhost:8080/api/swagger-ui.html#/
```
