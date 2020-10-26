package com.ecommerce.dataprovider;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.dataprovider.constants.Constants;
import com.ecommerce.dataprovider.entity.CustomerEntity;
import com.ecommerce.dataprovider.gateway.CustomerGateway;
import com.ecommerce.dataprovider.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CustomerDataProvider implements CustomerGateway {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerDataProvider(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> listAll() {
        return customerRepository.findAll();
    }

    public CustomerEntity findById(Long id) throws HandlerValidationException {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isPresent()) {
            return customerEntity.get();
        } else {
            log.error(Constants.msgNotFound);
            throw new HandlerValidationException(Constants.msgNotFound);
        }
    }

    @Transactional
    public CustomerEntity saveOrUpdate(CustomerEntity customerEntity, boolean update) {
        if (update) {
            final CustomerEntity customerEntityUpdated = customerRepository.findById(customerEntity.getId()).get();
            customerEntityUpdated.setAddress(customerEntity.getAddress());
            customerEntityUpdated.setCelPhone(customerEntity.getCelPhone());
            customerEntityUpdated.setCity(customerEntity.getCity());
            customerEntityUpdated.setDateOfBirth(customerEntity.getDateOfBirth());
            customerEntityUpdated.setDistrict(customerEntity.getDistrict());
            customerEntityUpdated.setEmail(customerEntity.getEmail());
            customerEntityUpdated.setName(customerEntity.getName());
            customerEntityUpdated.setZipCode(customerEntity.getZipCode());
            return customerRepository.saveAndFlush(customerEntityUpdated);
        }
        return customerRepository.saveAndFlush(customerEntity);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
