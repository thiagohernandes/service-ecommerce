package com.ecommerce.dataprovider.gateway;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.dataprovider.entity.ItemOrderEntity;
import com.ecommerce.dataprovider.entity.ProductEntity;

import java.util.List;

public interface ItemOrderGateway {

    List<ItemOrderEntity> listAll();
    List<ItemOrderEntity> listAllByOrderId(Long orderId);
    ItemOrderEntity findById(Long id) throws HandlerValidationException;
    ItemOrderEntity saveOrUpdate(ItemOrderEntity productEntity, boolean update);
    void deleteById(Long id);

}
