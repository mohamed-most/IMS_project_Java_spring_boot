# Inventory Management System - Backend (Spring Boot & MySQL)

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.0-brightgreen)](https://spring.io/projects/spring-boot)  
[![MySQL](https://img.shields.io/badge/MySQL-8-orange)](https://www.mysql.com/)  
[![License](https://img.shields.io/badge/License-MIT-lightgrey)](LICENSE)

---

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Prerequisites](#prerequisites)
5. [Installation & Setup](#installation--setup)
6. [API Endpoints](#api-endpoints)
7. [Project Structure](#project-structure)
8. [Security Flow](#security-flow)
9. [Future Improvements](#future-improvements)
10. [Author](#author)
11. [License](#license)

---

## Overview

This is the **backend** of an Inventory Management System built with **Spring Boot** and **MySQL**.  
It provides a **secure and scalable API** for managing inventory, users, and roles, including:

- JWT authentication and role-based access control
- CRUD operations with pagination
- Dynamic filtering of data
- Secure and stateless session management

---

## Features

### Database Design

- Efficient **MySQL relational database**
- One-to-many and many-to-many relationships for inventory, users, and roles

### CRUD Operations

- Full support for **Create, Read, Update, Delete** operations
- Pagination for handling large datasets

### Dynamic Filtering

- **Spring Data JPA Specifications** for flexible searching and filtering

### Security

- **Spring Security + JWT Authentication**
- Role-based access control (Admin, Manager, Employee)
- Stateless session management

### API Documentation

- Organized under `/api/v1`
- Public endpoints: `/api/v1/auth/**`
- Protected endpoints require valid JWT tokens

---

## Technology Stack

- **Backend:** Spring Boot (v4.0)
- **Database:** MySQL
- **Security:** Spring Security, JWT
- **ORM:** Spring Data JPA, Hibernate
- **Build Tool:** Maven

---

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- MySQL 8+
- Basic SQL knowledge

---

## Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/username/IMS_project-backend.git
cd IMS_project-backend
