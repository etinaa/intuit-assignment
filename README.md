# Home Assignment By Andrei Etin

[Requirements](assignment.md)

[Things that may be improved](todo.md)

Comments for solution:
1. Used relational database PostgreSQL. I want to show my experience with relational databases and Liquibase.
2. For unit testing used H2 database. My liquibase schema work well not only for postgres.
3. 3 package levels in codebase: Data, Business logic (service), API(controller)
4. Data from CSV upload when application started. We can simply change service with another solution. For example upload by REST Post method for multipart file or Event(Message) from message queue and reading from S3.

### Dev
Use docker compose file for debugging. It starts PostgreSQL database.
```bash
cd environment
docker compose up -d
```

### Test
```bash
./gradlew clean check
```
Used Checkstyle - linter, PMD, SpotBugs - static code analyzers

Integration testing with Testcontainers
```bash
./gardlew integTest
```

### Build
Spring Boot App
```bash
./gradlew clean build -Dbuild.number=1.0.0
```

Docker Image
```bash
./gradlew bootBuildImage -Dbuild.number=1.0.1
```

### Ops
1. Swagger UI - http://localhost:8080/swagger-ui/index.html
2. Info about service - http://localhost:8080/actuator/info
3. Health checks - http://localhost:8080/actuator/health
4. Metrics - http://localhost:8080/actuator/prometheus
