package com.viepovsky.student;

import com.viepovsky.student.dto.request.CreateStudentRequest;
import com.viepovsky.student.dto.request.UpdateStudentRequest;
import com.viepovsky.student.dto.response.StudentResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Validated
class StudentController {
    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping
    ResponseEntity<List<StudentResponse>> fetchAllStudents() {
        List<Student> students = service.getAll();
        return ResponseEntity.ok(mapper.mapToStudentResponseList(students));
    }

    @GetMapping(path = "/{number}")
    ResponseEntity<StudentResponse> fetchStudent(@PathVariable @Min(0) Long number) {
        var student = service.getByStudentNumber(number);
        return ResponseEntity.ok(mapper.mapToStudentResponse(student));
    }

    @PostMapping
    ResponseEntity<StudentResponse> createStudent(@RequestBody @Valid CreateStudentRequest request) {
        var student = mapper.mapToStudent(request);
        var createdStudent = service.create(student);
        return ResponseEntity.created(URI.create("/api/v1/students/" + request.getStudentNumber())).body(mapper.mapToStudentResponse(createdStudent));
    }

    @PutMapping(path = "/{number}")
    ResponseEntity<Void> updateStudent(@RequestBody UpdateStudentRequest request, @PathVariable @Min(0) Long number) {
        var student = mapper.mapToStudent(request);
        service.update(student, number);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{number}")
    ResponseEntity<Void> deleteStudent(@PathVariable Long number) {
        service.delete(number);
        return ResponseEntity.noContent().build();
    }
}
