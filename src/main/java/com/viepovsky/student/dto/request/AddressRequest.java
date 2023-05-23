package com.viepovsky.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddressRequest {
    @NotBlank(message = "Country must not be blank")
    private String country;
    @NotBlank(message = "City must not be blank")
    private String city;
    @NotBlank(message = "Zip code must not be blank")
    private String zipCode;
    @NotBlank(message = "Street must not be blank")
    private String street;
}
