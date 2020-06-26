# trucker-producer



### Usage

#### Vehicle 
http://ec2-3-236-117-16.compute-1.amazonaws.com:8080/api/vehicles

#### Readings
http://ec2-3-236-117-16.compute-1.amazonaws.com:8080/api/readings

#### Alerts
http://ec2-3-236-117-16.compute-1.amazonaws.com:8081/api/alerts?priority=High&Vin=WP1AB29P63LA60179










docker build -t truckerproducer .

docker run -p 8080:8080 --env-file prop.env truckerproducer

docker ps

docker images ls

docker container rm -f 



sudo usermod -a -G docker jenkins #add jenkins to docker

sudo service jenkins restart
