# Multiple Databases Spring Boot Project

## Overview

This project demonstrates how to connect a Spring Boot application to two different databases (PostgreSQL and MySQL) using Docker Compose. The application includes simple APIs to interact with each database.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
  - [Clone the Repository](#clone-the-repository)
  - [Docker Setup](#docker-setup)
  - [Spring Boot Application](#spring-boot-application)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Built With](#built-with)
- [License](#license)

## Features

- Connect to PostgreSQL and MySQL databases using HikariCP.
- Use Docker Compose to manage database containers.
- Simple RESTful APIs for CRUD operations on both databases.

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── redowl/
│   │           └── multipledbconfig/
│   │               ├── newSYS/
│   │               │   ├── dao/
│   │               │   ├── models/
│   │               │   ├── service/
│   │               │   └── controller/
│   │               ├── PrimaryDatabaseConfig.java
│   │               └── SecondaryDatabaseConfig.java
│   └── resources/
│       ├── application.yml
│       └── application-dev.yml
└── docker-compose.yml
```

## Prerequisites
-  Docker
-  Docker Compose
-  Java 8 or higher
-  Maven


## Setup
### Clone the Repository

```plaintext
git clone https://github.com/Gehan-Chandima-Rakwana/Multiple-Db-Config.git
cd multiple-databases-spring-boot
```

### Docker Setup

#### 1 Start the Docker containers:

```plaintext
bash
docker-compose up -d
```

This command will start PostgreSQL and MySQL containers.


### Spring Boot Application

#### 1 Build the application:

```plaintext
bash
mvn clean install
```

#### 2 Run the application:

```plaintext
bash
mvn spring-boot:run
```

The application will start on port 8080.


# API Endpoints
## Primary Database (PostgreSQL)

#### Get Member Details by ID
        GET /api/v1/multiple-databases/member-details/get/{id}

#### Add Member Details
        POST /api/v1/multiple-databases/member-details/add

## Secondary Database (MySQL)

#### Get User Details by ID
        GET /api/v1/multiple-databases/user-details/get/{id}

#### Add User Details
        POST /api/v1/multiple-databases/user-details/add

## Built With

```plaintext
    Spring Boot - Framework for building Java applications
    Docker - Containerization platform
    PostgreSQL - Open-source relational database
    MySQL - Open-source relational database
```
