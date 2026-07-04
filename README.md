# Student Management System (Java Swing + PostgreSQL)

## Overview

The Student Management System is a desktop application developed using **Java Swing** for the user interface and **PostgreSQL** as the backend database.

The application demonstrates how a Java desktop application communicates with a relational database using **JDBC** while implementing complete **CRUD (Create, Read, Update, Delete)** functionality for managing student records.

---

## Features

- Add new student records
- View all students in a JTable
- Update existing student information
- Delete student records
- Clear input fields
- Real-time database operations using JDBC
- User-friendly desktop interface

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Java Swing | Desktop GUI |
| JDBC | Database Connectivity |
| PostgreSQL | Database |
| pgAdmin | Database Management |
| VS Code / Eclipse | IDE |

---

## Project Structure

```
StudentManagementSystem/
│
├── src/
│   ├── Main.java
│   ├── ConsoleMain.java
│   ├── StudentForm.java
│   ├── StudentDAO.java
│   └── DBConnection.java
│
├── lib/
│   └── postgresql-42.7.3.jar
│
└── README.md
```

---

## Database Setup

### 1. Create Database

```sql
CREATE DATABASE studentdb;
```

### 2. Create Table

```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    branch VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(50)
);
```

---

## Database Configuration

Open **DBConnection.java** and update your PostgreSQL credentials.

```java
Connection conn = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/studentdb",
    "postgres",
    "your_password"
);
```

Replace:

```
your_password
```

with your PostgreSQL password.

---

## Installation & Execution

### Clone the Repository

```bash
git clone https://github.com/yourusername/student-management-system.git


### Navigate to the Source Folder

```bash
cd StudentManagementSystem/src


### Compile the Project

```bash
javac -cp "..\lib\postgresql-42.7.3.jar" *.java


### Run the Application

```bash
java -cp ".;..\lib\postgresql-42.7.3.jar" Main
```

---

## Application

The application provides an intuitive graphical interface that allows users to:

- Add student records
- Update student information
- Delete student records
- View records in a table
- Manage data stored in PostgreSQL

### Screenshots

Add screenshots of your application here.

Example:

```
screenshots/
├── Home.png
├── AddStudent.png
└── StudentList.png
```

---

## Learning Outcomes

This project strengthened my understanding of:

- Java Swing GUI development
- JDBC connectivity
- PostgreSQL integration
- CRUD operations
- Object-Oriented Programming (OOP)
- Layered project architecture
- Desktop application development

---

## Future Enhancements

- Search students by ID or Name
- Input validation
- Export data to CSV or Excel
- Improved UI design
- Login & Authentication
- Sorting and filtering
- Pagination for large datasets

---

## Author

Ramnath Shanbhag J

Information Science Engineering Student

GitHub: https://github.com/ramnathshanbhag2005

LinkedIn: *(Add your LinkedIn URL here)*



## License

This project is developed for educational and learning purposes.
