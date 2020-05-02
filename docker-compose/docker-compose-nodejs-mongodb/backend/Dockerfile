FROM node:latest
 
#  app work directory
WORKDIR /usr/src/app
  
# dependencies
COPY package*.json ./
 
RUN npm install
  
# app source
COPY . .
  
EXPOSE 3000:3000
CMD [ "node", "server.js" ]