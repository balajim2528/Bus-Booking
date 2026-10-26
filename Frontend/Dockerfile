
FROM node:20-alpine AS build

WORKDIR /app

COPY package*.json ./
RUN npm ci

COPY . .
RUN npm run build

RUN mkdir -p /app/webroot && \
    INDEX_FILE="$(find dist -type f -name index.html | head -n 1)" && \
    test -n "$INDEX_FILE" && \
    cp -a "$(dirname "$INDEX_FILE")"/. /app/webroot/

FROM nginx:alpine

COPY --from=build /app/webroot/ /usr/share/nginx/html/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
