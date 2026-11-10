package com.example.crud_api_demo;
import java.util.Map;
import java.util.Arrays;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {

    private Student[] students = new Student[10];

    private int count = 0;

    @PostMapping
    public String addStudent(@RequestBody Student student) {

        if (count >= students.length) {
            return "Array is full";
        }

        students[count] = student;

        count++;

        return "Student added successfully";
    }

    @GetMapping
    public Student[] getStudents() {
        return Arrays.copyOf(students, count);
    }
    @PutMapping("/{id}")
    public String updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {
                students[i] = updatedStudent;
                return "Student updated successfully";
            }
        }

        return "Student not found";
    }

    @PatchMapping("/{id}")
    public String patchStudent(
            @PathVariable int id,
            @RequestBody Map<String, Object> updates) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {

                if (updates.containsKey("name")) {
                    students[i].setName((String) updates.get("name"));
                }

                if (updates.containsKey("age")) {
                    students[i].setAge(
                            ((Number) updates.get("age")).intValue()
                    );
                }

                return "Student updated successfully";
            }
        }

        return "Student not found";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[count - 1] = null;
                count--;

                return "Student deleted successfully";
            }
        }

        return "Student not found";
    }
}