# Lab 2 — JPA & Hibernate CRUD

This project demonstrates the four JPA operations required through **DELETE** in the course manual (pages 3–11): **CREATE, READ, UPDATE, DELETE**.

## Prerequisites
- Java 21, Maven, MySQL Server on `localhost:3306`.
- Create the database in MySQL Workbench:

```sql
CREATE DATABASE IF NOT EXISTS jpadb1;
```

## Run
1. Open this project in IntelliJ IDEA and reload Maven.
2. Run `com.site.Main`.
3. When the Run console asks for the local MySQL root password, type it and press Enter. The password is not saved to the project.
4. Observe Hibernate's INSERT, SELECT, UPDATE and DELETE statements and success messages.

The demonstration **deletes its test record at the end**, so the newly created row will not remain in the table after execution. Previous database rows remain unaffected.

## Source files
- `Student.java`: `@Entity`, primary key, fields.
- `Main.java`: CREATE (`persist`), READ (`find`), UPDATE (modify entity and `commit`), DELETE (`remove`).
- `META-INF/persistence.xml`: MySQL/Hibernate settings; no password stored in source control.

Instructor's JPA lab manual: entity/configuration p. 2; create p. 3, 5; read p. 4, 6; update p. 8; delete p. 11.
