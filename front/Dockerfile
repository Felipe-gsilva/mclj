FROM node:21-alpine

WORKDIR /front/

COPY package.json .

RUN npm install

COPY . .

EXPOSE 5173

CMD ["npm", "run", "dev", "--host"]
