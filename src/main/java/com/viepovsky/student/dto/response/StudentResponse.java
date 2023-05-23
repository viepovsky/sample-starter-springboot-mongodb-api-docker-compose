package com.viepovsky.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String firstName;
    private String lastName;
    private String gender;
    private Long studentNumber;
    private AddressResponse address;
    private List<String> subjectsAttended;
}
