# rest-book

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

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
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/rest-book-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy Classic

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)



### Comandos

mvn -U io.quarkus:quarkus-maven-plugin:create \                                                                                       ✔  20.9.0 
-DprojectGroupId=org.esdras.quarkus.starting \
-DprojectArtifactId=rest-book \
-DclassName="org.esdras.quarkus.starting.BookResource" \
-Dpath="/api/books" \
-Dextensions="resteasy-jsonb"

        CRIAR ESCOPO


mvn quarkus:dev ISSO TA NO DEVELOPMENT MODE QUE TEM HOT RELOAD DO QUARKUS


//ISSO PROS EXECUTAVEIS JAR
mvn package -DskipTests pra pular os testes
mvn package -DskipTests -Dquarkus.package.type=uber-jar    pro jar uber
java -jar -Dquarkus.log.category."org.esdras".level=INFO target/rest-book-1.0.0-SNAPSHOT-runner.jar  e isso aqui roda o jar em pacote e tbm mudar as propriedades

//PRO EXECUTAVEL NATIVO DO GRAALVM QUE GERA UM EXECUTAVEL EM BINARIO
mvn package -Pnative
FICA RAPIDO DEMAIS SLC
./target/rest-book-1.0.0-SNAPSHOT-runner DEPOIS E SO RODAR O JAR, SO QUE NÃO PRECISA DE RODAR NA JVM, PQ JA FICA DENTRO DO EXECUTAVEL
 FICA TOP DEMAIS
mvn verify -Pnative roda os testes

mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.tag=native
NATIVAMENTE


RODAR O DOCKER
docker run -i --rm -p 8080:8080 esdras/esdras:native