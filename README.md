# quarkus-rest-client Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Context
CRUD application with Quarkus, which use the RestClient to interact with external WebService of 
`quarkus-service-message` Quarkus app exposed on `https://localhost:8081/message`.

The application, using a Proxy class, create an HTTP request, process the result and return the HTTP response.
Example request: `https://localhost:8081/message`

Open another Git terminal and typing
`while true; do sleep 1; curl http://localhost:8080/message; echo -e '\n'; done`
you can see the requests from this app to the `quarkus-service-message` app 

Fault Tolerance specification using `@Fallback` is to focus on the following aspects:
- Timeout: Define a duration for a timeout
- Retry: Define criteria on when to retry
 -Fallback: provide an alternative solution for a failed execution.
- CircuitBreaker: offer a way to fail fast by automatically failing execution to prevent the system overloading and indefinite wait or timeout by the clients.
- Bulkhead: isolate failures in part of the system while the rest part of the system can still function.

- In the application.properties we add proxy properties for interact with external WebService
of `http://localhost:8081`

- For Packaging the application, digit: mvn compile package
After this, running the application digiting: 
java -jar target/quarkus-app/quarkus-rest-client-1.0.0-SNAPSHOT.jar

## Tecnologies used
Extension:
- RESTEasy: write rest service
- RESTEasy Jackson: using Jackson annotations for to help to write rest service
- Rest-Client: use a proxy class for make http request
- Rest-Client-Jackson: using Jackson annotations for make http request
- Smallrye Fault Tolerance: handles fault-tolerant for network services

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-rest-client-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- REST Client Classic ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### REST Client

Invoke different services through REST with JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
