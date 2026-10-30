# Customer Management System

A console-based Customer Management System developed using **Java, Hibernate ORM, and MySQL**. This project demonstrates CRUD operations and Hibernate entity relationships for managing customers, customer details, orders, and offers.

## Technologies Used

- Java
- Hibernate ORM 5.6.4
- MySQL
- JDBC
- Eclipse IDE

## Features

### Customer Management
- Add new customers.
- Store customer details.
- Fetch customer records.
- Fetch customer information along with customer details.
- Update customer details.
- Delete customer records.

### Order Management
- Add orders for existing customers.
- Retrieve customer details using an order ID.
- Fetch all orders belonging to a particular customer.

### Offer Management
- Add new offers.
- Fetch all available offers.
- Assign multiple offers to multiple orders.

## Hibernate Entity Relationships

| Relationship | Entities |
|---|---|
| One-to-One | Customer – Customer Details |
| One-to-Many | Customer – Orders |
| Many-to-One | Orders – Customer |
| Many-to-Many | Orders – Offer |

## Database Tables

- `customer`
- `customer_details`
- `orders`
- `offers`
- `order_offer` (Many-to-Many join table)

## Project Structure

```text
CustomerManagementSystem/
│
├── src/
│   ├── com.main/
│   │   └── OrdersMain.java
│   │
│   └── com.module/
│       ├── customer.java
│       ├── customer_details.java
│       ├── Orders.java
│       └── Offer.java
│
├── hibernate.cfg.xml
└── README.md
```

## Configuration and Execution

1. Create a database in MySQL.
2. Configure database connection details in `hibernate.cfg.xml`.
3. Add the required Hibernate and MySQL dependencies.
4. Open the project in Eclipse.
5. Run the main class to access the application menu.

## Key Learning Outcomes

- Understanding Hibernate ORM.
- Implementing One-to-One, One-to-Many, Many-to-One, and Many-to-Many relationships.
- Performing CRUD operations using Hibernate.
- Managing database transactions.
- Working with Hibernate sessions.
- Understanding relational database mapping.

## Author

**Manoj V.**

BCA Graduate | Aspiring Java Developer
