package com.ecommerce.dataprovider.mapper;

import com.ecommerce.core.usecase.http.CustomerHttp;
import com.ecommerce.dataprovider.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerEntity httpToEntity(CustomerHttp customerHttp) {
        return CustomerEntity.builder()
                .id(customerHttp.getId())
                .address(customerHttp.getAddress())
                .celPhone(customerHttp.getCelPhone())
                .city(customerHttp.getCity())
                .dateOfBirth(customerHttp.getDateOfBirth())
                .district(customerHttp.getDistrict())
                .email(customerHttp.getEmail())
                .name(customerHttp.getName())
                .zipCode(customerHttp.getZipCode())
                .build();
    }

    public static CustomerHttp entityToHttp(CustomerEntity customerHttp) {
        return CustomerHttp.builder()
                .id(customerHttp.getId())
                .address(customerHttp.getAddress())
                .celPhone(customerHttp.getCelPhone())
                .city(customerHttp.getCity())
                .dateOfBirth(customerHttp.getDateOfBirth())
                .district(customerHttp.getDistrict())
                .email(customerHttp.getEmail())
                .name(customerHttp.getName())
                .zipCode(customerHttp.getZipCode())
                .build();
    }

    public static List<CustomerHttp> entityToHttp(List<CustomerEntity> listaEntity) {
        return listaEntity.stream()
                .map(entity -> entityToHttp(entity))
                .collect(Collectors.toList());
    }
}
