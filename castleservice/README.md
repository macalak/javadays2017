# Castle catalog service

Simple service example which provides:
- Castle management
- Castle search

API is accessible on [http://localhost:8080/castles](http://localhost:8080/castles)

## Jolokia

* [Heap memory used](http://localhost:8080/jolokia/read/java.lang:type=Memory/HeapMemoryUsage/used)
* [Actuator metrics endpoint](http://localhost:8080/jolokia/read/org.springframework.boot:type=Endpoint,name=metricsEndpoint)
