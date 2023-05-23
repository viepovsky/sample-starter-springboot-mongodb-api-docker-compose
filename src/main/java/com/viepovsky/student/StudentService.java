package com.viepovsky.student;

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

    void create(Student student) {
        if (repository.existsByStudentNumber(student.getStudentNumber())) {
            throw new IllegalArgumentException("Student with given number: " + student.getStudentNumber() + " already exists.");
        }
        repository.save(student);
    }

    void update(Student student, Long number) {
        var studentToUpdate = repository
                .findByStudentNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Student with given number: " + number + " does not exists."));
        studentToUpdate.updateFrom(student);
        repository.save(studentToUpdate);
    }

    void delete(Long number) {
        var student = repository
                .findByStudentNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Student with given number: " + number + " does not exists."));
        repository.delete(student);
    }
}
