package com.ecommerce.core.usecase;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.http.ProductHttp;
import com.ecommerce.dataprovider.ProductDataProvider;
import com.ecommerce.dataprovider.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase {

    private final ProductDataProvider productDataProvider;

    @Autowired
    public ProductUseCase(final ProductDataProvider productDataProvider) {
        this.productDataProvider = productDataProvider;
    }

    public List<ProductHttp> listAll() {
        return ProductMapper.entityToHttp(productDataProvider.listAll());
    }

    public ProductHttp findById(Long id) throws HandlerValidationException {
        return ProductMapper.entityToHttp(productDataProvider.findById(id));
    }

    public ProductHttp saveUpdate(ProductHttp productHttp, boolean update) {
        return ProductMapper.entityToHttp(
                productDataProvider.saveOrUpdate(ProductMapper.httpToEntity(productHttp), update));
    }

    public void delete(Long id) {
        productDataProvider.deleteById(id);
    }

}
