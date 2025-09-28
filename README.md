# Inventory Management System API

This is a **Spring Boot backend application** for managing inventory, including products, suppliers, and orders. The API provides full CRUD functionality and order management with stock updates.

---

## **Features**

- **Products**
  - Add, update, delete, and list products
  - Automatic stock management

- **Suppliers**
  - Add, update, delete, and list suppliers

- **Orders**
  - Place orders linked to products
  - Automatically updates product stock
  - Update order status (`Pending`, `Shipped`, `Delivered`)

---

## **Tech Stack**

- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **Build Tool:** Maven
- **API Testing:** Postman

---

## **Prerequisites**

- Java 11+ installed
- Maven installed
- MySQL installed and running

---

## **Configuration**

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
