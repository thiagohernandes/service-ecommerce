package com.ecommerce.dataprovider;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.dataprovider.constants.Constants;
import com.ecommerce.dataprovider.entity.ProductEntity;
import com.ecommerce.dataprovider.gateway.ProductGateway;
import com.ecommerce.dataprovider.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ProductDataProvider implements ProductGateway {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDataProvider(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> listAll() {
        return productRepository.findAll();
    }

    public ProductEntity findById(Long id) throws HandlerValidationException {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if(productEntity.isPresent()) {
            return productEntity.get();
        } else {
            log.error(Constants.msgNaoEncontrado);
            throw new HandlerValidationException(Constants.msgNaoEncontrado);
        }
    }

    @Transactional
    public ProductEntity saveOrUpdate(ProductEntity productEntity, boolean update) {
        if (update) {
            final ProductEntity productEntityUpdated = productRepository.findById(productEntity.getId()).get();
            productEntityUpdated.setDescription(productEntity.getDescription());
            productEntityUpdated.setPrice(productEntity.getPrice());
            productEntityUpdated.setQuantity(productEntity.getQuantity());
            return productRepository.saveAndFlush(productEntityUpdated);
        }
        return productRepository.saveAndFlush(productEntity);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
