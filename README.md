# Demo DAO JDBC

A Java app to manage sellers and departments in a MySQL database.

The app uses JDBC and the DAO (Data Access Object) pattern. You can run manual tests in the terminal.

## Tools

- Java (the IntelliJ project uses JDK 25)
- JDBC
- MySQL
- MySQL Connector/J
- IntelliJ IDEA

The project does not use Maven or Gradle. Add the JDBC driver as a JAR file.

## Features

For sellers and departments, you can:

- Add a new record and get its ID.
- Update a record by ID.
- Delete a record by ID.
- Find a record by ID.
- List all records by name.

You can also find sellers by department. Each seller has a department.

## Project files

```text
src/
  application/       Main and Main2: manual tests
  db/                Database connection and errors
  model/
    dao/             DAO interfaces and DaoFactory
    entities/        Seller and Department
    impl/            DAO classes with JDBC
```

The DAO interfaces list the database methods. The JDBC classes run the SQL commands. DaoFactory creates the DAO objects with a database connection.

## How to run

### 1. Create the database

Start MySQL. Use this SQL to create a new database and its tables:

```sql
CREATE DATABASE IF NOT EXISTS demo_dao_jdbc;
USE demo_dao_jdbc;

CREATE TABLE department (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE seller (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(60) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    BirthDate DATE NOT NULL,
    BaseSalary DOUBLE NOT NULL,
    DepartmentId INT NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (DepartmentId) REFERENCES department (Id)
);
```

If you already have these tables, you can use them. Add some departments and sellers before you run tests that find or update records.

### 2. Set the connection

Edit `db.properties` in the main project folder:

```properties
user=YOUR_USER
password=YOUR_PASSWORD
dburl=jdbc:mysql://localhost:3306/demo_dao_jdbc
```

Use your MySQL user and password. If your database has a different name, change the URL.

Run the app from the main project folder. The app reads `db.properties` from this folder.

### 3. Add the JDBC driver

Open the project in IntelliJ IDEA and set the JDK.

Add the MySQL Connector/J JAR in **File > Project Structure > Modules > Dependencies**.

### 4. Run the tests

- Run `application.Main` for seller tests.
- Run `application.Main2` for department tests.

Check the IDs in the test code before you run it. Use IDs that exist in your database:

| Test | ID in the code |
| --- | --- |
| Find a seller | Seller 3 |
| Find sellers by department | Department 2 |
| Add a seller | Department 2 |
| Update a seller | Seller 1 |
| Find a department | Department 4 |
| Update a department | Department 6 |

Each run adds a record and updates a record. For the delete test, enter an ID in the terminal. MySQL can block a department delete if the department still has sellers.

These are manual tests. Check the database or find the record again to see if an update worked.

## Main ideas

- Use DAO interfaces to keep database methods separate from the test code.
- Use `PreparedStatement` to set SQL values.
- Use `ResultSet` to read data.
- Get new IDs from the database after an insert.
- Use `INNER JOIN` to get seller and department data together.
- Convert dates between `LocalDate` and `java.sql.Date`.
- Handle database errors and close resources in `finally`.
