[![Java CI](https://github.com/yacosta738/deutsche-bank-demo/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/yacosta738/deutsche-bank-demo/actions/workflows/ci-cd.yml)
![coverage](.github/badges/jacoco.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=bugs)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=yacosta738_deutsche-bank-demo&metric=coverage)](https://sonarcloud.io/summary/new_code?id=yacosta738_deutsche-bank-demo)

# Deutsche Bank Demo 💶

This is a demo project for Deutsche Bank. The project was made with [MVC](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) architectural pattern.

## 🛰️ Requirements
Java 17 or higher

## 📡 How to run
1. Clone the project
2. Run the database with `docker-compose -f infrastructure/postgresql.yml up -d` (optional). If you don't want to use docker, you can use your own database. Just change the `spring.datasource.url` property in `application-dev.yml` file. The default database is `deutsche_bank_demo` and the default user is `my_admin` with password `my_password`.
3. Run `./mvnw spring-boot:run`
4. Open your browser and go to `http://localhost:8080`
5. Enjoy!

## 🧪 How to run tests
1. Clone the project
2. Run `./mvnw test`
3. Enjoy!

## 📰 Documentation
The documentation is available at [Swagger UI](http://localhost:8080/doc/swagger-ui/index.html)

## 🛰 Example of curl request
1. Create a new NACE record
    ```shell
    curl --location --request POST 'http://localhost:8080/nace' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "level": 1,
        "code": "code",
        "parent": "parent",
        "description": "description",
        "includes": "includes",
        "also_includes": "alsoIncludes",
        "rulings": "rulings",
        "excludes": "excludes",
        "reference": "reference"
    }'
    ```

2. Get a NACE record by id
    ```shell
    curl --location --request GET 'http://localhost:8080/nace/7'
    ```

3. Get a NACE record by code
    ```shell
    curl --location --request GET 'http://localhost:8080/nace/c/AA'
    ```
