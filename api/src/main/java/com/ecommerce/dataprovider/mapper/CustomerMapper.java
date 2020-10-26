package com.ecommerce.dataprovider.mapper;

import com.ecommerce.core.usecase.http.CustomerHttp;
import com.ecommerce.dataprovider.entity.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerEntity httpToEntity(CustomerHttp http) {
        return CustomerEntity.builder()
                .id(http.getId())
                .address(http.getAddress())
                .celPhone(http.getCelPhone())
                .city(http.getCity())
                .dateOfBirth(http.getDateOfBirth())
                .district(http.getDistrict())
                .email(http.getEmail())
                .name(http.getName())
                .zipCode(http.getZipCode())
                .build();
    }

    public static CustomerHttp entityToHttp(CustomerEntity entity) {
        return CustomerHttp.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .celPhone(entity.getCelPhone())
                .city(entity.getCity())
                .dateOfBirth(entity.getDateOfBirth())
                .district(entity.getDistrict())
                .email(entity.getEmail())
                .name(entity.getName())
                .zipCode(entity.getZipCode())
                .build();
    }

    public static List<CustomerHttp> entityToHttp(List<CustomerEntity> list) {
        return list.stream()
                .map(entity -> entityToHttp(entity))
                .collect(Collectors.toList());
    }
}
