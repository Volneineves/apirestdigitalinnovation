# Construindo uma API Rest de consulta de cidades do Brasil do zero até a produção

## Deploy Heroku
* <a href="https://springbootdigitalinnovation.herokuapp.com/swagger-ui.html#/" target="_blank">Swagger</a>
* <a href="https://springbootdigitalinnovation.herokuapp.com/countries" target="_blank">Countries</a>
* <a href="https://springbootdigitalinnovation.herokuapp.com/states" target="_blank">States</a>
* <a href="https://springbootdigitalinnovation.herokuapp.com/cities" target="_blank">Cities</a>
#### Distance:
* <a href="https://springbootdigitalinnovation.herokuapp.com/distances/by-points?from=4929&to=5254" target="_blank">Point</a>
* <a href="https://springbootdigitalinnovation.herokuapp.com/distances/by-cube?from=4929&to=5254" target="_blank">Cube</a>

## Requirements

* Linux
* Git
* Java 11
* Docker
* IntelliJ Community
* Heroku CLI

## DataBase

### Postgres

```shell script
//pgAdmin Query Tool:

CREATE DATABASE cities
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```

### Populate and implementation

* [DATA](https://github.com/Volneineves/apirestdigitalinnovation/tree/main/PostgreSQL)

```shell script
//PSQL Tool:
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access
```shell script
psql -U youruser cities
```

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 11
+ Maven Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)

### Heroku

* [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-java)
