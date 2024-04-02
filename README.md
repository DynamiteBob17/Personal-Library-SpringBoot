# About
- can save books by names and add personal comments to them as well as delete the books
- content served with thymeleaf

## How to run
- edit the **application.properties** file in *src/main/resources*[^1]
- See the [official docs](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-running-your-application.html)
- **or** if you have [Java 17+](https://www.oracle.com/java/technologies/downloads/#java17) run `./mvnw clean spring-boot:run`
- Should be running on **localhost** on port 8080

[^1]: requires a database to be set up which can be done either [locally](https://www.prisma.io/dataguide/mongodb/setting-up-a-local-mongodb-database) or in the [MongoDB Atlas Cloud](https://www.mongodb.com/docs/atlas/getting-started/)
