# Spring Boot & Supabase: Product Management API

### Developed by **PaKo Araya**

🔗 LinkedIn: [https://www.linkedin.com/in/franarayah/](https://www.linkedin.com/in/franarayah/)

![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.0-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) ![Supabase](https://img.shields.io/badge/Supabase-PostgreSQL-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)

This project is a modern **RESTful API** built with **Spring Boot 3** and connected to a **PostgreSQL** cloud database via **Supabase**. It implements a complete CRUD system with advanced search logic and persistence in custom database schemas.

---

## ✨ Key Features

- 🚀 **Full CRUD:** Complete product management (Create, Read, Update, Delete).
- 🔍 **Advanced Search:** Category filters and name-based search (Case-Insensitive).
- ☁️ **Cloud Native:** Direct connection to Supabase using JDBC/HikariCP.
- 📂 **Custom Schema:** Configured to operate within the `littlestore` schema.
- 📖 **Swagger UI:** Integrated interactive API documentation.
- 🪵 **Professional Logging:** Full traceability using SLF4J/Logback.

---

## 🛠️ Tech Stack

| Component | Technology |
| :--- | :--- |
| **Language** | Java 25 (OpenJDK) |
| **Framework** | Spring Boot 3.4.x (Snapshot) |
| **Persistence** | Spring Data JPA / Hibernate 7 |
| **Database** | PostgreSQL 17 (via Supabase) |
| **Documentation** | SpringDoc OpenAPI (Swagger) |
| **Build Tool** | Maven |

---

## 📂 Project Structure

```bash
src/main/java/com/example/supabase
├── controller    # REST Endpoints (ProductController)
├── entity        # Data Model (Product)
├── repository    # JPA Interfaces (IProductRepository)
└── service       # Business Logic (ProductService)

## 🚀 Getting Started

### 1. Prerequisites
- JDK 21 or higher (Developed using Java 25).
- A [Supabase](https://supabase.com/) account.

### 2. Database Setup
Before running the application, ensure the schema exists in your Supabase SQL Editor:
```sql
CREATE SCHEMA IF NOT EXISTS littlestore;
```

### 3. Configuration

Update src/main/resources/application.yml with your database credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://your-db-url:5432/postgres
    username: postgres
    password: your-password
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        default_schema: littlestore
```

### 4. Running the Application

```bash
./mvnw spring-boot:run

The API will be available at http://localhost:8080 and the interactive documentation at:
👉 http://localhost:8080/swagger-ui-custom.html

🗺️ API Endpoints SummaryMethodEndpointDescriptionGET/api/v1/productsGet all productsGET/api/v1/products/{id}Find product by IDGET/api/v1/products/category/{name}Filter by categoryGET/api/v1/products/search?name=...Search by name coincidencePOST/api/v1/productsCreate or update a productDELETE/api/v1/products/{id}Delete product by ID

Gemini said
Entiendo, parece que el bloque anterior se cortó o el formato no se visualizó correctamente. Aquí tienes la segunda mitad del documento (desde Getting Started) en formato Markdown puro dentro de un bloque de código para que no se pierda nada:

Markdown
## 🚀 Getting Started

### 1. Prerequisites
- JDK 21 or higher (Developed using Java 25).
- A [Supabase](https://supabase.com/) account.

### 2. Database Setup
Before running the application, ensure the schema exists in your Supabase SQL Editor:
```sql
CREATE SCHEMA IF NOT EXISTS littlestore;
3. Configuration
Update src/main/resources/application.yml with your database credentials:

YAML
spring:
  datasource:
    url: jdbc:postgresql://your-db-url:5432/postgres
    username: postgres
    password: your-password
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        default_schema: littlestore
4. Running the Application
Bash
./mvnw spring-boot:run
The API will be available at http://localhost:8080 and the interactive documentation at:
👉 http://localhost:8080/swagger-ui-custom.html

🗺️ API Endpoints Summary
Method	Endpoint	Description
GET	/api/v1/products	Get all products
GET	/api/v1/products/{id}	Find product by ID
GET	/api/v1/products/category/{name}	Filter by category
GET	/api/v1/products/search?name=...	Search by name coincidence
POST	/api/v1/products	Create or update a product
DELETE	/api/v1/products/{id}	Delete product by ID
📊 Logging & Traceability
The project utilizes SLF4J to record critical operations for real-time monitoring:

INFO: Logs successful searches and creations.

WARN: Warnings for deletion attempts.

ERROR: Notifications when a resource is not found.

📝 Contact
If you have any questions or suggestions, feel free to reach out:
📧 franarayah@gmail.com

🪪 License
Licensed under the MIT License.

