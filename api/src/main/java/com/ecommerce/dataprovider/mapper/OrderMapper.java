package com.ecommerce.dataprovider.mapper;

import com.ecommerce.core.usecase.http.OrderHttp;
import com.ecommerce.dataprovider.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderEntity httpToEntity(OrderHttp http) {
        return OrderEntity.builder()
                .id(http.getId() == null ? null : http.getId())
                .customer(CustomerMapper.httpToEntity(http.getCustomer()))
                .itens(ItemOrderMapper.httpToEntity(http.getItens()))
                .dateBuy(http.getDateBuy())
                .build();
    }

    public static OrderHttp entityToHttp(OrderEntity entity) {
        return OrderHttp.builder()
                .id(entity.getId())
                .customer(CustomerMapper.entityToHttp(entity.getCustomer()))
                .itens(ItemOrderMapper.entityToHttp(entity.getItens()))
                .dateBuy(entity.getDateBuy())
                .build();
    }

    public static List<OrderHttp> entityToHttp(List<OrderEntity> list) {
        return list.stream()
                .map(entity -> entityToHttp(entity))
                .collect(Collectors.toList());
    }

}
