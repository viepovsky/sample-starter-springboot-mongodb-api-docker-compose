package com.viepovsky.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
class StudentController {
    private final StudentService service;

    @GetMapping
    List<Student> fetchAll() {
        return service.getAll();
    }

    @PostMapping
    void create(@RequestBody Student student) {
        service.create(student);
    }

    @PutMapping(path = "/{number}")
    void update(@RequestBody Student student, @PathVariable Long number) {
        service.update(student, number);
    }

    @DeleteMapping(path = "/{number}")
    void delete(@PathVariable Long number) {
        service.delete(number);
    }
}
