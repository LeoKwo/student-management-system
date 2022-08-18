# Student Management System

This is a simple Student Management System web application using Spring Boot, Spring MVC, Thymeleaf, Spring Data JPA, and MySQL database.

## Technologies used
- Java 11
- Spring Boot
- Spring MVC
- Spring Data JPA (Hibernate)
- MySQL
- Thymeleaf
- Docker

## This app needs you to have MySQL on either your localhost or docker to run

**Requires a _sms_ database**

```
# For your localhost MySQL server
/usr/local/mysql/bin/mysql -u root -p
create database sms;
```

```
# For MySQL Server running on Docker
docker pull mysql:8.0.30
# Create a Docker network. Both MySQL and this app will run on Docker.
docker network create sms-mysql # you can use your preferred name here
# Create a MySQL container
docker run --network sms-mysql --name MYSQL_CONTAINER_NAME -e MYSQL_ROOT_PASSWORD=1234567 -p 3306:3306 -d mysql:8.0.30
# Use bash
docker exec -it MYSQL_CONTAINER_NAME bin/bash
# Configure mysql inside docker
mysql -uroot -p
# Create sms db
create database sms;
```
### Note
**application.properties file is configured to run on Docker with MySQL running on Docker. To run this project with your localhost MySQL server, use this:**
```spring.datasource.url=jdbc:mysql://localhost:YOUR_MYSQL_PORT/sms?allowPublicKeyRetrieval=true&useSSL=false```

## This app is *Dockerized*
To create a new container

#### First, use maven to build a package of this app
Built package should be  ```/target/Student-Management-System-0.0.1-SNAPSHOT.jar```

#### Then
```
# In project root path, use command to build a docker image of this app
docker build -t NEW_SMS_CONTAINER_NAME:TAG_NAME .
# Create and run a docker container of this image
docker run --network sms-mysql --name sms-docker-network -p 8081:8080 NEW_SMS_CONTAINER_NAME:TAG_NAME
```

## Finally
Visit ```localhost:8081/list``` to view result.

![image](/readme_imgs/1.png)
![image](/readme_imgs/2.png)
![image](/readme_imgs/3.png)
![image](/readme_imgs/4.png)
