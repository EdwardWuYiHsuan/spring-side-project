# Edward Side Project
## Technology Stack
* Spring Boot (Web、AMQP、Test、Actuator)
* RabbitMQ
* Java Lombok
* no Database
* Spring Cloud - OpenFeign
* Micrometer register Prometheus metrics

## Function Topic
* [Spring Custom Qualifier Annotation](https://www.concretepage.com/spring/spring_custom_qualifier_annotation#java-config)
* [Spring Cloud Open Feign](https://www.baeldung.com/spring-cloud-openfeign)
* [Spring Boot Monitoring Tool with Actuator](https://kucw.github.io/blog/2020/7/spring-actuator/)

## URL Path
* Swagger API Doc
  * http://localhost:8080/swagger-ui/index.html
* Actuator
  * http://localhost:8080/actuator
  * http://localhost:8080/actuator/health
  * http://localhost:8080/actuator/env
  * http://localhost:8080/actuator/prometheus

TODO : 
* goose
* APM
* RabbitMQ produce and consumer with prefetch
* Cache
    * First-Level Cache : redis
    * Second-Level Cache : Guava、Caffine Cache、Spring Cache
* MySQL
* Mongo DB