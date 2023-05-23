package com.viepovsky.student;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Document
@NoArgsConstructor
class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    @Indexed(unique = true)
    private Long studentNumber;
    private Address address;
    private List<String> subjectsAttended;
    private LocalDateTime createdDate;

    Student(String firstName, String lastName, String gender, Long studentNumber, Address address, List<String> subjectsAttended) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (Optional.ofNullable(gender).isPresent()) {
            if (!gender.matches("\\b(MALE|FEMALE)\\b")) {
                throw new IllegalArgumentException("Gender must be declared as MALE or FEMALE");
            } else {
                this.gender = Gender.valueOf(gender);
            }
        }
        this.studentNumber = studentNumber;
        this.address = address;
        this.subjectsAttended = subjectsAttended;
        this.createdDate = LocalDateTime.now();
    }

    Student(String firstName, String lastName, String gender, Address address, List<String> subjectsAttended) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (Optional.ofNullable(gender).isPresent()) {
            if (!gender.matches("\\b(MALE|FEMALE)\\b")) {
                throw new IllegalArgumentException("Gender must be declared as MALE or FEMALE");
            } else {
                this.gender = Gender.valueOf(gender);
            }
        }
        this.address = address;
        this.subjectsAttended = subjectsAttended;
        this.createdDate = LocalDateTime.now();
    }


    void updateFrom(Student student) {
        this.firstName = Optional.ofNullable(student.getFirstName()).orElse(firstName);
        this.lastName = Optional.ofNullable(student.getLastName()).orElse(lastName);
        this.gender = Optional.ofNullable(student.getGender()).orElse(gender);
        this.address = Optional.ofNullable(student.getAddress()).orElse(address);
        this.subjectsAttended = Optional.ofNullable(student.getSubjectsAttended()).orElse(subjectsAttended);
    }

    enum Gender {
        MALE, FEMALE
    }
}
