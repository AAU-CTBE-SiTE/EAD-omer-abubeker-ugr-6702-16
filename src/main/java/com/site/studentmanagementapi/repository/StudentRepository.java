package com.site.studentmanagementapi.repository;

import com.site.studentmanagementapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}