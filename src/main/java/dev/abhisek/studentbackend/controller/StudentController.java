package dev.abhisek.studentbackend.controller;

import dev.abhisek.studentbackend.entity.Student;
import dev.abhisek.studentbackend.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student/")
public class StudentController {

    private final StudentService service;

    /**
     * Get a Student with matching id
     *
     * @param id the id received from the path as {@link PathVariable}
     * @return a response entity which contains the student with matching id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity
                .ok(
                        service.getStudentById(id)
                );
    }

    /**
     * Get all the students present in the database
     *
     * @return a response entity containing all the student as list
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(service.getAllStudent());
    }

    /**
     * Adds the given student entity to the database
     *
     * @param student received from {@link RequestBody} and mapped with {@link  Student}
     * @return the added student entity
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addStudent(student));
    }

    /**
     * Deletes the student from database with matching id
     *
     * @param id the id received from the path as {@link  PathVariable }
     * @return the deleted student entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> removeStudent(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.removeStudentById(id));
    }


    /**
     * Updates the Student present in the database with given Student
     *
     * @param id      the id received from the path as {@link  PathVariable }
     * @param student received from {@link RequestBody} and mapped with Student
     * @return the updated student entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id,
                                                 @RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateStudent(id, student));
    }
}
