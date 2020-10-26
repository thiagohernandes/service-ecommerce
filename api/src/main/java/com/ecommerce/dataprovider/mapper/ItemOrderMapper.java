package com.ecommerce.dataprovider.mapper;

import com.ecommerce.core.usecase.http.ItemOrderHttp;
import com.ecommerce.dataprovider.entity.ItemOrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemOrderMapper {

    public static ItemOrderEntity httpToEntity(ItemOrderHttp http) {
        return ItemOrderEntity.builder()
                .id(http.getId() != null ? http.getId() : null)
                .idproduct(http.getIdproduct())
                .idorder(http.getIdorder())
                .price(http.getPrice())
                .quantity(http.getQuantity())
                .build();
    }

    public static ItemOrderHttp entityToHttp(ItemOrderEntity entity) {
        return ItemOrderHttp.builder()
                .id(entity.getId() != null ? entity.getId() : null)
                .idproduct(entity.getIdproduct())
                .idorder(entity.getIdorder())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    public static List<ItemOrderHttp> entityToHttp(List<ItemOrderEntity> list) {
        List<ItemOrderHttp> listHttp = new ArrayList<>();
        if (list != null) {
            listHttp = list.stream()
                    .map(entity -> entityToHttp(entity))
                    .collect(Collectors.toList());
        }
        return listHttp;
    }

    public static List<ItemOrderEntity> httpToEntity(List<ItemOrderHttp> list) {
        List<ItemOrderEntity> listEntity = new ArrayList<>();
        if (list != null) {
            listEntity = list.stream()
                    .map(entity -> httpToEntity(entity))
                    .collect(Collectors.toList());
        }
        return listEntity;
    }

}
