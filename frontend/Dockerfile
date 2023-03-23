FROM node:18-alpine as build
WORKDIR /app

RUN npm install -g @angular/cli

COPY ./package.json .
RUN npm install
COPY . .
#RUN ng build

FROM nginx:latest as runtime
COPY --from=build /app/dist/painel-apuracao-fiscal /usr/share/nginx/html
COPY /nginx.conf  /etc/nginx/conf.d/default.conf

EXPOSE 80