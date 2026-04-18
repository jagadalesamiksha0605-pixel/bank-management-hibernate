Bank Management System (Hibernate + PostgreSQL)

## Project Overview

This is a Bank Management System developed using Hibernate ORM and PostgreSQL, following a Layered Architecture.
The project demonstrates how to perform core banking operations with proper separation of concerns using DAO, Service and DTO layers.

## Features

 - Customer Management (Add, View)
 - Account Management(Create, Fetch)
 - Transactions( Deposit, Withdraw)
 - Layered Architecture( DAO, Service, Controller/Main)
 - Database integration using Hibernate
 - Efficient ORM-based data handling 
 
## Tech Stack

 - Java
 - Hibernate(ORM Framework)
 - Maven(Build Tool)
 - PostgreSQL(Database)
 - JDBC(under the hood)
 
## Setup & Installation
 1.Clone the repository
   git clone https://github.com/jagadalesamiksha0605-pixel/bank-management-hibernate.git
 2.Congigure Database
   - Install PostgreSQL
   - Create a database(e.g. bank_db)
   - Update credentials in: hibernate.cfg.xml
 3.Build the project
   mvn clean install
 4.Run the application
   Run the main class: BankDriver.java
   
## Architecture explanation

	This project follows Layered Architecture:
	-DTO(Data Transfer Object)
		Represents entities like Customer, Account, Transaction
	-DAO(Data Access Object)
		Handles database operations using Hibernate
	-Service Layer
		Contains business logic
	-Main Layer
		Entry point of application
		
## Learning Outcomes
	- Understanding Hibernate ORM
	- Working with PostgreSQL database
	- Implementing layered architecture
	- Performing CRUD operations using Hibernate
	- Managing transactions and sessions
	
## Future Enhancements
	- Add REST APIs using Spring Boot
	- Add authentication & authorization
	- Create web UI (HTML/CSS/JS)
	- Add logging and exception handling
	
	Author
	Samiksha Jagadale
	Computer Engineering Student
   
