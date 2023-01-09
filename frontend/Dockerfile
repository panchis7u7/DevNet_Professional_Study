FROM node:18.13-alpine
WORKDIR /app
COPY . .
RUN apk add --update yarn
RUN yarn install && yarn build
ENTRYPOINT [ "yarn" ]
CMD [ "start" ]
EXPOSE 3000