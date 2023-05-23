package com.viepovsky.student;

import com.viepovsky.student.dto.CreateStudentRequest;
import com.viepovsky.student.dto.UpdateStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    List<Student> getAll() {
        return repository.findAll();
    }

    void create(CreateStudentRequest request) {
        var student = mapper.mapToStudent(request);
        if (repository.existsByStudentNumber(student.getStudentNumber())) {
            throw new IllegalArgumentException("Student with given number: " + student.getStudentNumber() + " already exists.");
        }
        repository.save(student);
    }

    void update(UpdateStudentRequest request, Long number) {
        var student = mapper.mapToStudent(request);
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
