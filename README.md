[![Java CI](https://github.com/yacosta738/deutsche-bank-demo/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/yacosta738/deutsche-bank-demo/actions/workflows/ci-cd.yml)
![coverage](.github/badges/jacoco.svg)

# deutsche-bank-demo

This is a demo project for Deutsche Bank.

## Requirements
Java 17 or higher

## How to run
1. Clone the project
2. Run `./mvnw spring-boot:run`
3. Open your browser and go to `http://localhost:8080`
4. Enjoy!

## How to run tests
1. Clone the project
2. Run `./mvnw test`
3. Enjoy!

## Documentation
The documentation is available at [Swagger UI](http://localhost:8080/doc/swagger-ui/index.html)

## Example of curl request
Create a new NACE record

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

Get a NACE record by id

```shell
curl --location --request GET 'http://localhost:8080/nace/7'
```
