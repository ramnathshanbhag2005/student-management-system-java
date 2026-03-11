Student Management System (Java Swing + PostgreSQL)

1. Project Overview

The Student Management System is a desktop application built using **Java Swing** for the graphical user interface and **PostgreSQL** as the database.

The application allows users to perform basic **CRUD operations (Create, Read, Update, Delete)** on student records. It demonstrates how a Java desktop application can interact with a relational database using **JDBC**.



 2. Technologies Used

* Java (JDK 17+ / 21 / 25 compatible)
* Java Swing (Graphical User Interface)
* JDBC (Java Database Connectivity)
* PostgreSQL
* pgAdmin
* VS Code  / Eclipse



3. Features

* Add new student records
* View student records in a tabular format (JTable)
* Update existing student details
* Delete student records
* Clear input fields
* Real-time database interaction



 4. Project Structure


StudentManagementSystem
│
├── src
│   ├── Main.java
│   ├── ConsoleMain.java
│   ├── StudentForm.java
│   ├── StudentDAO.java
│   └── DBConnection.java
│
├── lib
│   └── postgresql-42.7.3.jar
│
└── README.md




5. Database Setup

 Step 1: Create Database


CREATE DATABASE studentdb;


Step 2: Create Table


CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    branch VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(50)
);




 6. Database Configuration

Open **DBConnection.java** and update the database password.


Connection conn = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/studentdb",
    "postgres",
    "your_password_here"
);

Replace `your_password_here` with your PostgreSQL password.



 7. How to Run the Project

### Step 1: Clone the Repository


git clone https://github.com/yourusername/student-management-system.git


Step 2: Navigate to Source Folder


cd StudentManagementSystem/src
```

 Step 3: Compile the Project


javac -cp "..\\lib\\postgresql-42.7.3.jar" *.java


Step 4: Run the Application


java -cp ".;..\\lib\\postgresql-42.7.3.jar" Main


8. Application Interface

The application provides a graphical interface where users can:

* Enter student details
* Perform CRUD operations
* View student records in a table

You can add screenshots of the application here.


 9. Learning Outcomes

This project helped in understanding:

* Java Swing GUI development
* JDBC database connectivity
* CRUD operations using SQL
* Desktop application architecture
* Structuring a Java project



 10. Future Improvements

* Search functionality
* Input validation
* Export data to CSV
* Improved user interface
* Authentication system



 11. Author

Ramnath Shanbhag J
Information Science Engineering Student