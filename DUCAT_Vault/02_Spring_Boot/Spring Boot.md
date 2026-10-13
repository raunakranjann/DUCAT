# Spring Boot Masterclass: Core Annotations, REST APIs, and MVC Architecture

## 1. Core Spring Boot Annotations & Architecture

### The Main Application Annotation

- **`@SpringBootApplication`**: The main entry point annotation for a Spring Boot application. It is a convenience annotation that combines three key annotations:
      
    - **`@SpringBootConfiguration`**: Marks the class as a source of bean definitions and application configuration.
        
    - **`@EnableAutoConfiguration`**: Automatically configures the application based on the classpath dependencies available in the project. For instance, if `spring-boot-starter-web` is detected, it automatically enables the web server and configures web components.
        
    - **`@ComponentScan`**: Tells Spring to scan and find components, configurations, and services within the application package.
        
### Application Startup Workflow

- **Text Representation of Flowchart:**
    
    Plaintext
    
    ```
    SpringApplication.run
           ↓
      Container
           ↓
    Configuration Load
           ↓
    Embedded Server Starts
    ```
    
    _(Source:)_

### Bean Definition and Dependency Injection

- **`@Configuration`**: Applied to a Java class that contains bean definitions (e.g., `public class MyConfig {}`).
    
      
    
- **`@Bean`**: Applied to a method inside a configuration class. Spring internally calls the method, captures the returned object, and registers it in the Spring IoC container.
    
      
    
- **`@Autowired`**: Used for automatic dependency injection. It instructs Spring to locate the required bean object and inject it automatically.
    
      
    

## 2. Architecture of Spring Boot REST API

REST (Representational State Transfer) APIs allow front-end applications, mobile apps, or external services to communicate with the backend using standard HTTP methods.

  

### Layered Architecture Flow

- **Text Representation of Architecture Diagram:**
    
      
    
    Plaintext
    
    ```
    User (httpRequest)
           ↓
     Rest Controller
           ↓
      Service Layer
           ↓
     Repository Layer
           ↓
       DataBase
    ```
    
    _(Source:)_
    
      
    

## 3. REST API HTTP Methods & Mapping

|**HTTP Method**|**Purpose**|**Typical Request Example**|**Example Response**|
|---|---|---|---|
|**GET**|Read/fetch data from the server|`GET /api/accounts/101`|`{"account_id": 101, "name": "Raunak", "balance": 21273}`|
|**POST**|Create a new resource|`POST /api/accounts` with body `{"name": "Raunak", "balance": 151}`|`{"account_id": 102, "name": "Raunak", "balance": 151}`|
|**PUT**|Completely update an existing resource|`PUT /api/accounts/102` with body `{"name": "Prachi", "balance": 101}`|Updated resource representation|
|**PATCH**|Partially update specific fields of a resource|`PATCH /api/accounts/102` with body `{"name": "Ram"}`|Partially updated resource|
|**DELETE**|Remove an existing resource|`DELETE /api/account/102`|Status confirmation / Empty response|

## 4. Handling Request Data: Parameters vs. Bodies

### `@RequestBody` vs. `@RequestParam` vs. `@PathVariable`

- **`@RequestBody`**: Extracts data from the HTTP JSON body. Typically used with `POST`, `PUT`, and `PATCH` requests to deserialize JSON payloads into Java objects.
    
      
    
- **`@RequestParam`**: Reads query parameters from the URL string (e.g., `GET /student?id=101`, where `id` is the parameter name and `101` is the value). Frequently used for optional filtering, searching, or small parameter values.
    
      
    
- **`@PathVariable`**: Extracts a dynamic segment directly from the URL path pattern (e.g., `/{value}`) to identify a specific resource.
    
      
    

### Comparison Table

|**Feature**|**@RequestParam**|**@PathVariable**|**@RequestBody**|
|---|---|---|---|
|**Source Location**|Query string (`?key=value`)|URL path segment (`/{value}`)|HTTP request body (JSON)|
|**Primary Use Case**|Filtering, searching, sorting|Identifying a unique/specific resource|Creating or updating complex resources|
|**Common HTTP Methods**|`GET`|`GET`, `DELETE`, `PUT`|`POST`, `PUT`, `PATCH`|

## 5. Model-View-Controller (MVC) Architecture

MVC is a software design pattern that decouples application data, user interface components, and request-handling logic to achieve loosely coupled applications and easier maintenance.

  

### MVC Component Interaction

- **Text Representation of Architecture Flowchart:**
    
      
    
    Plaintext
    
    ```
    [ User Interface: HTML, CSS, Thymeleaf ] (View)
                ↕                         ↕
    [ Handles requests & selects response ] (Controller)
                ↕                         ↕
    [ Application Data & Business Logic ] (Model)
    ```
    
    _(Source:)_
    
      
    

### Component Breakdown

1. **Model**: Represents application data, business/service layer logic, entities, DTOs (Data Transfer Objects), and repositories.
    
      
    
2. **View**: Responsible for rendering and displaying information to the user using technologies like HTML, CSS, JavaScript, and Thymeleaf.
    
      
    
3. **Controller**: Receives HTTP requests from users, invokes the service layer when business logic execution is required, and returns the appropriate view name or HTTP response.
    
      
    

## Quick Revision Points

- `@SpringBootApplication` bundles configuration, auto-configuration, and component scanning.
    
      
    
- Use `@Bean` inside classes marked with `@Configuration` to register objects into the Spring IoC container.
    
      
    
- Match HTTP request structures correctly: `@RequestBody` for payloads, `@RequestParam` for query filters, and `@PathVariable` for resource IDs.
    
      
    
- Spring Boot MVC separates concerns cleanly into Models (data), Views (UI/Thymeleaf), and Controllers (request handlers).