#!/usr/bin/env bash
mvn clean install

IMAGE_NAME=klinkbr/brinks-painel-backend:v1.0.0
sudo docker build -t $IMAGE_NAME .
sudo docker tag $IMAGE_NAME $IMAGE_NAME
sudo docker push $IMAGE_NAME