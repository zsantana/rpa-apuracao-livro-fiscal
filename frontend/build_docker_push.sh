#!/usr/bin/env bash

ng build --configuration=production

IMAGE_NAME=painel-frontend:v1.0.0
sudo docker build --no-cache -t $IMAGE_NAME .
sudo docker tag $IMAGE_NAME $IMAGE_NAME
sudo docker push $IMAGE_NAME
