# E-Commerce Store Application

A Spring Boot-based e-commerce platform where users can browse products, add them to their cart, and proceed with orders. The application integrates with a database for product management and Email Services.

## Features

- User registration
- Product catalog informations / Product Lists
- Shopping cart Add, Get, Remove & Remove All
- Order processing and checkout

## Technologies Used

- Spring Boot
- Hibernate / JPA
- MySQL
- Spring Boot Starter Mail / SMTP
- Maven

## Prerequisites

Make sure you have the following installed:

- JDK 8 or later
- Maven or Gradle
- MySQL
- IDE (e.g., IntelliJ IDEA or Eclipse)

## Installation

### Steps to follow
```bash
 1. Setup the database
git clone https://github.com/MOHAMMEDAMEERUDIN/EStore.git
cd EStore

 2. Setup the database
CREATE DATABASE estore;

 3. Configure Application Settings
spring.datasource.username={your username}
spring.datasource.password={your password}
.
.
spring.mail.username={your email id}
spring.mail.password={your password}

 4. Build and run the application
mvn clean install
mvn spring-boot:run

 5. Access the Application
Open your browser and go to http://localhost:8084 to access the e-store application.
