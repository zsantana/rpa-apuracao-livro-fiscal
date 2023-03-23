## Módulo BackEnd (API) para autenticação dos usuários e acesso ao painel de apuração fiscal

Módulo resposnável em prover informações de apuração fiscal.



## Build
mvn clean install


## Execução local
mvn quarkus:dev -Ddebug=false


# ============================
# Execução via docker-compose
# ============================

docker-compose --env-file ./.env up


# =====================================
# Geração de Chaves públicas e privadas
# =====================================

# gerando chave privada
openssl genrsa -out rsaPrivateKey.pem 2048

# gerando chave pública
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem

# convertendo chave privada formato PKCS#8
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem


