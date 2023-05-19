package dev.abhisek.studentbackend.services;

import dev.abhisek.studentbackend.entity.Student;
import dev.abhisek.studentbackend.exception.StudentNotFoundException;
import dev.abhisek.studentbackend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    /**
     * retrieves all the student from the database
     *
     * @return list of students
     */
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    /**
     * retrieves the student from the database and if the student doesn't exist it throws {@link StudentNotFoundException}
     *
     * @param id id of the student
     * @return the student of id if it exists in the database
     */
    public Student getStudentById(Integer id) {
        return repository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    /**
     * saves a student to the database
     *
     * @param student the given Student
     * @return the saved student
     */
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    /**
     * finds the student if it exists in the database.If the student exists it deletes the student otherwise throws {@link StudentNotFoundException}
     *
     * @param id id of the student
     * @return the deleted student
     */
    public Student removeStudentById(Integer id) {
        Student student = repository.findById(id).orElseThrow(StudentNotFoundException::new);
        repository.delete(student);
        return student;
    }

    /**
     * Finds the student by its id( if not exists throws{@link StudentNotFoundException} ). Instantiates a new student with given id and given  student as parameter. Then saves new student to the database.
     *
     * @param id      id of the student
     * @param student new student to be updated
     * @return updated student
     */
    public Student updateStudent(Integer id, Student student) {
        Student studentFromDB = repository.findById(id).orElseThrow(StudentNotFoundException::new);
        Student updatedStudent = Student
                .builder()
                .id(studentFromDB.getId())
                .name(student.getName())
                .address(student.getAddress())
                .build();
        return repository.save(updatedStudent);

    }
}
