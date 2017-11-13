# Infrastructure setup
To run services locally on your notebook install docker on Linux, or Docker Toolbox on Win.
## Graylog centralized logging
The Graylog server along with required dependencies (MongoDB, Elasticsearch) can be started
using the docker-compose. Just run `docker-compose up -d` from the docker/graylog folder.
* The Graylog UI is accessible on [http://192.168.99.100:9000/](http://192.168.99.100:9000/) (admin/admin)
##  Prometheus monitoring
The Prometheus server along with  Grafana  can be started using the docker-compose. 
Just run `docker-compose up -d` from the docker/prometheus folder.
* The Promettheus UI is accessible on [http://192.168.99.100:9090/](http://192.168.99.100:9090/)
* The Grafana UI is accessible on [http://192.168.99.100:3000/](http://192.168.99.100:3000/)


