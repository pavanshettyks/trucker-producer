# trucker-producer


docker build -t truckerproducer .

docker run -p 8080:8080 --env-file prop.env truckerproducer

docker ps

docker images ls

docker container rm -f 



sudo usermod -a -G docker jenkins #add jenkins to docker

sudo service jenkins restart
