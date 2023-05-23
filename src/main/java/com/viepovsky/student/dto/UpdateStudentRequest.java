package com.viepovsky.student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateStudentRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private AddressRequest address;
    private List<String> subjectsAttended;
}
