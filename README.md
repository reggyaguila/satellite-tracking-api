# satellite-tracking-api
RESTful APIs to perform CRUD operations on satellite records and employ data visualization tools to present tracking information interactively.

Project outline:


1. Project Setup:
Spring Boot Initialization:
Use Spring Initializr to create a new Spring Boot project
Include essential dependencies:
Spring Web: For building RESTful APIs
Spring Data JPA: For database interactions
MySQL Driver: For connecting to a MySQL database
Database Setup:
Database choice: MySQL
Set up SQL database and create the necessary tables for satellite tracking data: satellite ID, name, current position, velocity, altitude
Table structure:
Id
Name
Latitude
longitude
2. Core features:
demo.Satellite Entity and Data Model:
Define a demo.Satellite class:
Long id
String name
Double latitude
Double longitude
Annotate with JPA annotations (@eEntity, @Id, @GeneratedValue)
Repository Layer:
Create a SatelliteRepository interface extending JpaRepository<demo.Satellite, Long> to handle CRUD operations on the satellite data
Service Layer:
Implement a SatelliteService class to manage business logic
Methods: getAllSatellites(), getSatelliteById(), addSatellite(), updateSatellite(), deleteSatellite()
Error handling:
Try-catch blocks
Return simple error messages
Controller Layer:
Create a SatelliteController class with endpoints:
GET /satellites - Retrieve all satellites
GET /satellites/{id} - Retrieve a satellite by ID
POST /satellites - Add a new satellite
PUT /satellites/{id} - Update an existing satellite
DELETE /satellites/{id} - Delete a satellite
Use basic validation annotations (@Valid, @RequestBody)
3. Data fetching and tracking:
External data source integration:
Mock Data:
Manually input satellite positions
Optionally, create a simple method to simulate position updates
Tracking Logic
Focus on basic CRUD operations for satellite data
4. Database management:
Use Spring Data JPA for basic CRUD operations
5. Additional features:
Filter and Search:
Implement search functionality, such as finding satellites by name or by coordinate range
Logging and Monitoring:
Use Spring Boot's built in logging
6. Testing:
Create unit and integration tests for your service and repository layers using JUnit 
7. Frontend Interface:
	API only:
Focus on building a robust REST API
Use Postman to demonstrate API functionality
8. Deployment:
Run app locally


















Notes:


Spring boot?
Java framework that simplifies Java-based Spring apps (simplifies initial setup process)
Like a toolbox for building web apps
Built-in features: connecting to database, handling web requests, and managing security
-> Spring Boot Initializer: making things even easier: configures dependencies and generate project's foundational structure
-> Spring Data JPA: makes it easier to easily implement JPA-based repositories ... easier to build Spring-powered apps that use data access tech


mySQL?
SQL:
-> language used for managing and manipulating databases
->allows to perform tasks like querying data, updating records, inserting new data and deleting records
MySQL:
->specific relational database management system that uses SQL to manage data
->software that allows creation, management, and manipulation of databases using SQL language
->widely used in web apps
Tutorial:
https://www.youtube.com/watch?v=SenSzEgnvPE&t=10s (mySQL)
https://www.codecademy.com/learn/learn-sql (SQL)


Repository layer?
Part of application dedicated to managing data access and persistence
-> Intermediary between: Service Layer and Data Source
Extends Spring-provided repository interfaces (e.g., JpaRepository, CrudRepository)
Abstraction of data access:
Simplifies data operations
Decouples business logic from data access
Centralized data management:
Single point for data operations
Layered architecture:
Controller Layer
Handles HTTP requests and responses
Interacts with service layer to perform operations
Service layer:
Contains business logic and rules
Coordinates between controllers and repositories
Repository Layer:
Manages data persistence and retrieval
Interfaces directly with the database or other data sources
Data source layer:
Actual database or external data service


Jpa annotations?
Java Persistence API annotations are essential for defining how Java objects (entities) map to database tables and how their fields map to table columns
Annotations enable Object-Relational Mapping (ORM)
->Allows for interaction with databases using Java objects instead of writing raw SQL queries
Ex:
@Entity -> marks a class JPA entity
@Id -> specifies primary key of entity
@GeneratedValue -> specifies strategy for primary key generation
Annotations to use:
Basic mapping: @Entity , @Table, @Id, @GeneratedValue, @Column
Relationships: @OneToMany , @ManyToOne, @JoinColumn
Enumerations: @Enumerated
Validation: @NotNull , @Size , @Min , @Max

REST API
Application Programming Interface that conforms to design principles of Representational State Transfer architectural style
->API allows app to access resource w/n another app
->Client: app that accesses another app
->Server: app that provides the requested service

In order to create a REST API it must conform to six REST design principles (architectural constraints):
Uniform interface
API requests for same resource should look identical
Client-server decoupling
Client and server apps must be wholly independent of each other
Client app should only know URI of requested resource (uniform resource identifier)
Server app cannot modify client app other than passing requested data
Statelessness:
REST API are stateless
Stateless: each request needs to include all info necessary for processing it
Server apps are not allowed to store any data related to client request
Cacheability:
Resources should be cacheable on client or server side
Server responses need to contain info about whether caching allowed
Layered system architecture:
In REST APIs calls and responses go through diff layers
REST APIs need to be designed so that neither client nor server can tell whether it communicates w/ end app or intermediary
RAPI (REST API) communicate through HTTP requests: enables (CRUD)
Creating: POST request
Reading: GET request
Updating: PUT request
Deleting: DELETE request


Postman:
API platform for building and using APIs
Postman simplifies each step of API lifecycle and streamlines collaboration
