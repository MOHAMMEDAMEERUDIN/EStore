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

### 1. Clone the repository
```bash
git clone https://github.com/MOHAMMEDAMEERUDIN/EStore.git
cd EStore

### 2. Setup the database
```bash
CREATE DATABASE estore;

### 3. Configure Application Settings
```bash
spring.datasource.username={your username}
spring.datasource.password={your password}
spring.mail.username={your email id}
spring.mail.password={your password}

### 4. Build and run the application
```bash
mvn clean install
mvn spring-boot:run

### 5. Access the Application
```bash
Open your browser and go to http://localhost:8084 to access the e-store application.


