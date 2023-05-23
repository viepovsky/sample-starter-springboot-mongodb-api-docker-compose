package com.viepovsky.student;

import com.viepovsky.student.dto.request.AddressRequest;
import com.viepovsky.student.dto.request.CreateStudentRequest;
import com.viepovsky.student.dto.request.UpdateStudentRequest;
import com.viepovsky.student.dto.response.AddressResponse;
import com.viepovsky.student.dto.response.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class StudentMapper {
    Address mapToAddress(AddressRequest request) {
        return new Address(
                request.getCountry(),
                request.getCity(),
                request.getZipCode(),
                request.getStreet()
        );
    }

    Student mapToStudent(CreateStudentRequest request) {
        return new Student(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getStudentNumber(),
                mapToAddress(request.getAddress()),
                request.getSubjectsAttended()
        );
    }

    Student mapToStudent(UpdateStudentRequest request) {
        return new Student(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                mapToAddress(request.getAddress()),
                request.getSubjectsAttended()
        );
    }

    AddressResponse mapToAddressResponse(Address address) {
        return new AddressResponse(
                address.getCountry(),
                address.getCity(),
                address.getZipCode(),
                address.getStreet()
        );
    }

    StudentResponse mapToStudentResponse(Student student) {
        return new StudentResponse(
                student.getFirstName(),
                student.getLastName(),
                student.getGender().name(),
                student.getStudentNumber(),
                mapToAddressResponse(student.getAddress()),
                student.getSubjectsAttended()
        );
    }

    List<StudentResponse> mapToStudentResponseList(List<Student> students) {
        return students.stream()
                .map(this::mapToStudentResponse)
                .toList();
    }
}
