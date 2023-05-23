package com.viepovsky.student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    @Indexed(unique = true)
    private Long studentNumber;
    private Address address;
    private List<Subject> subjects;
    private LocalDateTime createdDate;

    Student(String firstName, String lastName, Gender gender, Long studentNumber, Address address, List<Subject> subjects, LocalDateTime createdDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentNumber = studentNumber;
        this.address = address;
        this.subjects = subjects;
        this.createdDate = createdDate;
    }

    void updateFrom(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.gender = student.getGender();
        this.address = student.getAddress();
        this.subjects = student.getSubjects();
    }

    enum Gender {
        MALE, FEMALE
    }
}
