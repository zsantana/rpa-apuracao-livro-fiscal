# RPA Apuração livro Fiscal

RPA Apuração livro Fiscal


# FrontEnd



## 💻 Getting started

```bash
## If not installed, install angular CLI
npm install -g @angular/cli

# Install the dependencies
$ yarn

# To finish, run the api service
$ yarn watch

```


# Backend


## Getting started Docker
```bash
# Install image from file build_docker_push.sh 
$ ./build_docker_push.sh 

# Started and attaches to containers for a service
$ docker-compose --env-file ./.env up
```


## Getting started Docker (Native Image)
```bash
# Install image from file build_docker_push.sh 
$ ./build_docker_native.sh 

# Started and attaches to containers for a service
$ docker-compose -f docker-compose-native.yml --env-file ./.env up
```


## ✔️ Required
* Maven: 3.8.4
* Java version: 17
* Docker version: 20.10.17
* Docker-compose version: v2.2.2


Docker Image:
* Minikube: v1.29.0
* Keycloak: 19.0.3
* postgres: 13
* jaegertracing/all-in-one: 1
* grafana/grafana: latest
* elasticsearch: 8.4.1
* Kibana: 8.4.1
* azul/zulu-openjdk: 17-latest


## Integrated tools:

Observability:

* smallrye-openapi
* smallrye-metrics
* smallrye-health 
* opentelemetry


Database:
* hibernate-reactive-panache
* reactive-pg-client


Authentication and Security:
* oidc-client
* keycloak-authorization

Other integrations:
* resteasy-reactive-jackson
* lombok
* mapstruct

Unit and Integration testing:
* testcontainers
* keycloak-admin-client
* test-oidc-server
* rest-assured



# Visão de Arquitetura
![image](https://user-images.githubusercontent.com/17239827/227523672-783dbcc5-9e64-480e-a54e-b2939f017ccb.png)




# Autor
Reinaldo Jesus Santana - reinaldojsantana@gmail.com
