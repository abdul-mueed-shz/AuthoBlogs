# Spring Boot Blog Application

This repository contains a blog application built with Spring Boot, utilizing Spring Security for robust authentication and MySQL for data persistence. The application allows users to create, edit, and delete blog posts. Authentication is managed via Spring Security, ensuring that only authenticated users can perform certain actions.

## Features

- **User Registration and Login**: Utilize Spring Security for handling user authentication.
- **CRUD Operations**: Create, Read, Update, and Delete blog posts.
- **Responsive UI**: Basic front-end using Thymeleaf to make it easy to interact with the application.
- **Security**: Use of Spring Security to manage user sessions and restrict access based on roles.

## Technologies Used

- **Spring Boot**: Framework for creating stand-alone, production-grade Spring based applications.
- **Spring Security**: Authentication and access-control framework.
- **MySQL**: Open-source relational database management system.
- **Thymeleaf**: Modern server-side Java template engine for web and standalone environments.
- **Maven**: Dependency management.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

```bash
Java 11 or higher
Maven
MySQL
```

### Installing
```
git clone https://github.com/yourusername/spring-boot-blog.git
cd spring-boot-blog
```


### Update application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```



### Run the application
```
mvn spring-boot:run
```


### Notes:

- Replace `yourusername`, `yourpassword`, `yourusername/spring-boot-blog`, and other placeholders with actual values specific to your project.
- Ensure all paths, URLs, and other specific data are correct for your project setup.
- This README template is quite generic and may need to be adapted based on the specific requirements or features of your application.


