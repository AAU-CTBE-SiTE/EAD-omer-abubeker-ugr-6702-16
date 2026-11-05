package com.craft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Addis Ababa", "Ethiopia");
    }

    @Bean
    public Subject math() {
        Subject subject = new Subject();
        subject.setSubjectName("Maths 101");
        return subject;
    }

    @Bean
    public Subject java() {
        Subject subject = new Subject();
        subject.setSubjectName("Java EE");
        return subject;
    }

    @Bean
    public Student student() {
        Student student = new Student();

        student.setId(101);
        student.setName("Omer Abubeker");
        student.setAge(20);
        student.setAddress(address());
        student.setSubjects(Arrays.asList(math(), java()));

        return student;
    }

    @Bean
    @Scope("prototype")
    public Student prototypeStudent() {
        Student student = new Student();

        student.setId(103);
        student.setName("Prototype Student");
        student.setAge(21);

        return student;
    }
}