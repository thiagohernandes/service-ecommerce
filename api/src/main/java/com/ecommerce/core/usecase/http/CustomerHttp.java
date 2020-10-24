package com.ecommerce.core.usecase.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerHttp {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dateOfBirth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("district")
    private String district;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("celPhone")
    private String celPhone;
    @JsonProperty("email")
    private String email;

}
