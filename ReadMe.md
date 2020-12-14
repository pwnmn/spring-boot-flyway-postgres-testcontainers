<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">Flyway & Postgres testing with docker test containers</h3>

  <p align="center">
    This project demonstrates how to setup a production-identical database using Flyway and a postgres
    docker test container for testing with Spring Boot.
    <br />
  </p>
</p>

<!-- ABOUT THE PROJECT -->
## About The Project

Quick demonstration on how to test the database layer of a spring boot application as close as possible to the the
environment it will run on. We're using a postgres instance running in a docker container that will be started solely
for the tests.
After the instance is started, the Flyway db schema migration will run all SQL scripts to initiate the database for the tests.
When this setup is completed, the Spring application context is started and runs the db layer tests.


### Built With

* [Spring Boot](https://spring.io/)
* [Testcontainers](https://www.testcontainers.org/)
* [Flyway](https://flywaydb.org/)
* [Apache Maven](https://spring.io/)


<!-- GETTING STARTED -->
## Getting Started

Import the project into an IDE of your choosing and run the tests.
Alternatively tests can be run with Maven using

  ```sh
  mvn clean test
  ```

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.


<!-- CONTACT -->
## Contact

Peter Weismann

[Project Link](https://github.com/pwnmn/spring-boot-flyway-postgres-testcontainers)