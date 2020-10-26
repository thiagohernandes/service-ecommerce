package com.ecommerce.core.usecase;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.http.CustomerHttp;
import com.ecommerce.dataprovider.CustomerDataProvider;
import com.ecommerce.dataprovider.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUseCase {

    private final CustomerDataProvider customerDataProvider;

    @Autowired
    public CustomerUseCase(final CustomerDataProvider customerDataProvider) {
        this.customerDataProvider = customerDataProvider;
    }

    public List<CustomerHttp> listAll() {
        return CustomerMapper.entityToHttp(customerDataProvider.listAll());
    }

    public CustomerHttp findById(Long id) throws HandlerValidationException {
        return CustomerMapper.entityToHttp(customerDataProvider.findById(id));
    }

    public CustomerHttp saveUpdate(CustomerHttp customerHttp, boolean update) {
        return CustomerMapper.entityToHttp(
                customerDataProvider.saveOrUpdate(CustomerMapper.httpToEntity(customerHttp), update));
    }

    public void delete(Long id) {
        customerDataProvider.deleteById(id);
    }

}
