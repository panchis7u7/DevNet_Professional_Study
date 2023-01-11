FROM node:18.13-alpine as build-stage
WORKDIR /app
COPY . .
RUN apk add --update yarn
RUN yarn install && yarn build

FROM nginx:1.23.3-alpine as production-stage
RUN mkdir /app
COPY --from=build-stage /app/out /app
EXPOSE 80
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf