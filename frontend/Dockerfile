FROM node:18.13-alpine as build-stage
WORKDIR /app
COPY . .
RUN apk add --update yarn
RUN yarn install && yarn build

FROM nginx:1.23.3-alpine as production-stage
WORKDIR /usr/share/nginx/html
COPY --from=build-stage /app/out .
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
EXPOSE 80