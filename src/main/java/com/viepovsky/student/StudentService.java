package com.viepovsky.student;

import com.viepovsky.exceptions.StudentExistsException;
import com.viepovsky.exceptions.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class StudentService {
    private final StudentRepository repository;

    List<Student> getAll() {
        return repository.findAll();
    }

    Student getByStudentNumber(Long number) {
        return repository.findByStudentNumber(number).orElseThrow(() -> new StudentNotFoundException("Student with given number: " + number + " does not exist."));
    }

    Student create(Student student) {
        if (repository.existsByStudentNumber(student.getStudentNumber())) {
            throw new StudentExistsException("Student with given number: " + student.getStudentNumber() + " already exists.");
        }
        return repository.save(student);
    }

    void update(Student student, Long number) {
        var studentToUpdate = repository
                .findByStudentNumber(number)
                .orElseThrow(() -> new StudentNotFoundException("Student with given number: " + number + " does not exist."));
        studentToUpdate.updateFrom(student);
        repository.save(studentToUpdate);
    }

    void delete(Long number) {
        var student = repository
                .findByStudentNumber(number)
                .orElseThrow(() -> new StudentNotFoundException("Student with given number: " + number + " does not exists."));
        repository.delete(student);
    }
}
