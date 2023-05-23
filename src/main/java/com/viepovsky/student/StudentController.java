package com.viepovsky.student;

import com.viepovsky.student.dto.CreateStudentRequest;
import com.viepovsky.student.dto.UpdateStudentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Validated
class StudentController {
    private final StudentService service;

    @GetMapping
    List<Student> fetchAll() {
        return service.getAll();
    }

    @PostMapping
    void create(@RequestBody @Valid CreateStudentRequest request) {
        service.create(request);
    }

    @PutMapping(path = "/{number}")
    void update(@RequestBody UpdateStudentRequest request, @PathVariable Long number) {
        service.update(request, number);
    }

    @DeleteMapping(path = "/{number}")
    void delete(@PathVariable Long number) {
        service.delete(number);
    }
}
