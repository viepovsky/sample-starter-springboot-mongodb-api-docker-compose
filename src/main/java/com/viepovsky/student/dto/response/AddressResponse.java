package com.viepovsky.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private String country;
    private String city;
    private String zipCode;
    private String street;
}
