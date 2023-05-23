package com.viepovsky.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateStudentRequest {
    @NotBlank(message = "First name must not be blank")
    private String firstName;
    @NotBlank(message = "Last name must not be blank")
    private String lastName;
    private String gender;
    @NotNull(message = "Student number must not be null")
    private Long studentNumber;
    @NotNull(message = "Address must not be null")
    private AddressRequest address;
    private List<String> subjectsAttended;
}
