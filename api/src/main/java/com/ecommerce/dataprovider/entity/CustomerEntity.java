package com.ecommerce.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "datebirth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "zipcode", nullable = false)
    private String zipCode;
    @Column(name = "celphone", nullable = false)
    private String celPhone;
    @Column(name = "email", nullable = true)
    private String email;

}
