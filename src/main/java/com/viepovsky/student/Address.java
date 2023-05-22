package com.viepovsky.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Address {
    private String country;
    private String city;
    private String zipCode;
    private String street;
}

