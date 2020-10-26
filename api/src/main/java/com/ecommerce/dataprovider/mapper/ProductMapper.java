package com.ecommerce.dataprovider.mapper;

import com.ecommerce.core.usecase.http.ProductHttp;
import com.ecommerce.dataprovider.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductEntity httpToEntity(ProductHttp http) {
        return ProductEntity.builder()
                .id(http.getId())
                .description(http.getDescription())
                .price(http.getPrice())
                .quantity(http.getQuantity())
                .build();
    }

    public static ProductHttp entityToHttp(ProductEntity entity) {
        return ProductHttp.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    public static List<ProductHttp> entityToHttp(List<ProductEntity> list) {
        return list.stream()
                .map(entity -> entityToHttp(entity))
                .collect(Collectors.toList());
    }
}
