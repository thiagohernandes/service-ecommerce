package com.ecommerce.dataprovider.gateway;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.http.OrderHttp;
import com.ecommerce.dataprovider.entity.OrderEntity;
import com.ecommerce.dataprovider.entity.ProductEntity;

import java.util.List;

public interface OrderGateway {

    List<OrderEntity> listAll();
    OrderEntity findById(Long id) throws HandlerValidationException;
    OrderEntity saveOrUpdate(OrderHttp orderHttp, boolean update) throws HandlerValidationException;
    void deleteById(Long id);

}
