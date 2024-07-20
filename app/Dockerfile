FROM docker.io/clojure:temurin-21-tools-deps-alpine

WORKDIR /app/

COPY . .

EXPOSE 8000

CMD [ "clojure", "-M:dev", "-m", "dev.core"]

