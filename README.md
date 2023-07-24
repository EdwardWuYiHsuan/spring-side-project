![basic workflow](https://github.com/EdwardWuYiHsuan/spring-side-project/actions/workflows/unit-test.yaml/badge.svg)

# Edward Side Project
This is a small project

## Technology Stack
* Spring Boot (Web、JPA、AMQP、Test、Actuator)
* MySQL
* Goose : database migration and schema management
* RabbitMQ
* Java Lombok
* Spring Cloud - OpenFeign
* Micrometer register Prometheus metrics
* Unit Test & Git Action

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

## Database Schema Migration
* `create database edward_spring_test;`
* `goose mysql "{username}:{password}@/edward_spring_test" status`
* `goose mysql "{username}:{password}@/edward_spring_test" create edward_spring_test_schema sql`
* `goose mysql "{username}:{password}@/edward_spring_test" up`
* `goose mysql "{username}:{password}@/edward_spring_test" down`

## TODO :
* APM
* RabbitMQ produce and consumer with prefetch
* Cache
    * First-Level Cache : redis
    * Second-Level Cache : Guava、Spring Cache (& Caffine Cache)
* MySQL
* Mongo DB