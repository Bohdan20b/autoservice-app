# Autoservice application
### 📗 ***Project description***
```
It's a RESTful API with possibility to create and save to database car service orders. 
```

List of options available:
* Create a new car and update it.
* Create a new master, update them, get their orders and count their salary.
* Create a new owner and update them.
* Create a new order, update it, add new commodity to order, count total price of the order.
* Create a new service, update it, change its status.
* Create a new commodity and update it.

### 💾 ***Project's structure***

Based on 3-layer architecture:
* Presentation layer - controllers.
* Application layer - services.
* Data access layer - repositories.

### 🔨 ***Project launch:***

1. Clone this project from GitHub. *Hint: If you use IntelliJ IDEA, use only Ultimate version*
2. Open pom.xml and reload all maven dependencies.
3. In terminal enter the following command: ```mvn clean package```.
4. After success, enter the following command: ```docker-compose up```.
5. Now you can test the program in your browser: [http://localhost:6868/swagger-ui.html]([http://localhost:6868/swagger-ui.html])

### 🧰 Application technologies:
* **[JDK 17](https://www.oracle.com/cis/java/technologies/javase/jdk11-archive-downloads.html)**
* **[Spring Boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)**
* **[Apache Maven](https://maven.apache.org/download.cgi)**
* **[PostgreSQL 15.1](https://www.postgresql.org/download/)**
* **[Liquibase](https://mvnrepository.com/artifact/org.liquibase/liquibase-core)**
* **[Swagger](https://mvnrepository.com/artifact/io.springfox/springfox-swagger2)**
* **[Docker](https://www.docker.com/products/docker-desktop/)**
