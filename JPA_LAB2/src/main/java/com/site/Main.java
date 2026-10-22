package com.site;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Password is requested locally and is never stored in the GitHub project.
        System.out.print("Enter your local MySQL root password: ");
        String password = new Scanner(System.in).nextLine();

        Map<String, Object> settings = new HashMap<>();
        settings.put("jakarta.persistence.jdbc.password", password);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("studentPU", settings);
        try {
            // CREATE: persist a new student in a transaction.
            Student student = new Student("Omer Abubeker", "Java script");
            try (EntityManagerScope scope = new EntityManagerScope(factory)) {
                EntityManager em = scope.entityManager();
                em.getTransaction().begin();
                em.persist(student);
                em.getTransaction().commit();
                System.out.println("CREATE SUCCESS: " + student);
            }

            int id = student.getId();

            // READ: find the student by primary key.
            try (EntityManagerScope scope = new EntityManagerScope(factory)) {
                Student found = scope.entityManager().find(Student.class, id);
                System.out.println("READ SUCCESS: " + found);
            }

            // UPDATE: modify a managed entity and commit.
            try (EntityManagerScope scope = new EntityManagerScope(factory)) {
                EntityManager em = scope.entityManager();
                em.getTransaction().begin();
                Student found = em.find(Student.class, id);
                if (found == null) throw new IllegalStateException("Student not found: " + id);
                found.setName("Bekele");
                em.getTransaction().commit();
                System.out.println("UPDATE SUCCESS: " + found);
            }

            // DELETE: remove the student and commit.
            try (EntityManagerScope scope = new EntityManagerScope(factory)) {
                EntityManager em = scope.entityManager();
                em.getTransaction().begin();
                Student found = em.find(Student.class, id);
                if (found == null) throw new IllegalStateException("Student not found: " + id);
                em.remove(found);
                em.getTransaction().commit();
                System.out.println("DELETE SUCCESS: student ID " + id);
            }

            System.out.println("ALL FOUR CRUD OPERATIONS COMPLETED!");
        } finally {
            factory.close();
        }
    }

    // Ensures EntityManager is closed and unfinished transactions are rolled back.
    private static class EntityManagerScope implements AutoCloseable {
        private final EntityManager em;
        EntityManagerScope(EntityManagerFactory factory) {
            em = factory.createEntityManager();
        }
        EntityManager entityManager() { return em; }
        @Override public void close() {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            em.close();
        }
    }
}
