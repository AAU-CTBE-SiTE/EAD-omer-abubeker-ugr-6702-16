package com.site.studentmanagementapi.service;

import com.site.studentmanagementapi.model.Student;
import com.site.studentmanagementapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // GET all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // UPDATE student
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());

        return studentRepository.save(existingStudent);
    }

    // DELETE student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}