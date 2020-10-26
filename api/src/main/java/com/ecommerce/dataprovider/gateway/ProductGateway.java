package com.ecommerce.dataprovider.gateway;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.dataprovider.entity.CustomerEntity;
import com.ecommerce.dataprovider.entity.ProductEntity;

import java.util.List;

public interface ProductGateway {

    List<ProductEntity> listAll();
    ProductEntity findById(Long id) throws HandlerValidationException;
    ProductEntity saveOrUpdate(ProductEntity productEntity, boolean update);
    void deleteById(Long id);

}
