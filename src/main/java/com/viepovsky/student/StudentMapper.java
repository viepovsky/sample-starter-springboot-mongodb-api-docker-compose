package com.viepovsky.student;

import com.viepovsky.student.dto.AddressRequest;
import com.viepovsky.student.dto.CreateStudentRequest;
import com.viepovsky.student.dto.UpdateStudentRequest;
import org.springframework.stereotype.Service;

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
}
