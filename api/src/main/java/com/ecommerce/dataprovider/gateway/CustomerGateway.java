package com.ecommerce.dataprovider.gateway;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.dataprovider.entity.CustomerEntity;

import java.util.List;

public interface CustomerGateway {

    List<CustomerEntity> listAll();
    CustomerEntity findById(Long id) throws HandlerValidationException;
    CustomerEntity saveOrUpdate(CustomerEntity customerEntity, boolean update);
    void deleteById(Long id);

}
