# Edward Side Project
## Technology Stack
* Spring Boot (Web、AMQP、Test、Actuator)
* RabbitMQ
* Java Lombok
* no Database
* Spring Cloud - OpenFeign
* Micrometer register Prometheus

## Function Topic
* [Spring Custom Qualifier Annotation](https://www.concretepage.com/spring/spring_custom_qualifier_annotation#java-config)
* [Spring Cloud Open Feign](https://www.baeldung.com/spring-cloud-openfeign)
* [Spring Boot Monitoring Tool with Actuator](https://kucw.github.io/blog/2020/7/spring-actuator/)

## API
[GET] localhost:8080/common
[GET] localhost:8080/actuator
[GET] localhost:8080/actuator/health
[GET] localhost:8080/actuator/env
[GET] localhost:8080/actuator/prometheus

TODO : 
* goose
* APM
* RabbitMQ produce and consumer with prefetch
* Cache
    * First-Level Cache : redis
    * Second-Level Cache : Guava、Caffine Cache、Spring Cache
* MySQL
* Mongo DB