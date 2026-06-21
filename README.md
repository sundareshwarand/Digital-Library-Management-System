# 📚 Digital Library Management System

A Java Swing-based Digital Library Management System developed using Java, JDBC, and MySQL. This project automates library operations such as book management, issuing books, returning books, and searching records.

## 🚀 Features

### Admin Module
- Add New Books
- View All Books
- Search Books
- Update Book Details
- Delete Books

### User Module
- View Available Books
- Search Books
- Issue Books
- Return Books

## 🛠 Technologies Used

- Java
- Java Swing (GUI)
- JDBC
- MySQL Database
- VS Code

## 📂 Project Structure

```
DigitalLibraryManagementSystem
│
├── LoginFrame.java
├── LibraryDashboard.java
├── AddBookFrame.java
├── ViewBooksFrame.java
├── SearchBookFrame.java
├── UpdateBookFrame.java
├── DeleteBookFrame.java
├── IssueBookFrame.java
├── ReturnBookFrame.java
├── DBConnection.java
└── mysql-connector-j-9.7.0.jar
```

## 🗄 Database

Database Name:

```sql
librarydb
```

### Books Table

```sql
CREATE TABLE books(
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    quantity INT
);
```

### Issued Books Table

```sql
CREATE TABLE issued_books(
    issue_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    student_name VARCHAR(100),
    issue_date DATE,
    return_date DATE
);
```

## ▶️ How to Run

### Compile

```bash
javac -cp ".;mysql-connector-j-9.7.0.jar" *.java
```

### Run

```bash
java -cp ".;mysql-connector-j-9.7.0.jar" LoginFrame
```

## 📸 Modules Implemented

- Login System
- Add Book
- View Books
- Search Book
- Update Book
- Delete Book
- Issue Book
- Return Book
- MySQL Database Connectivity

## 🎯 Objective

The objective of this project is to provide a complete automated library management system by digitizing book management, issue/return operations, and record maintenance through a user-friendly graphical interface.

## 👨‍💻 Developed By

**Sundareshwaran D**

Java Development Internship Project
