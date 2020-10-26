package com.ecommerce.core.usecase;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.http.OrderHttp;
import com.ecommerce.dataprovider.OrderDataProvider;
import com.ecommerce.dataprovider.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUseCase {

    private final OrderDataProvider orderDataProvider;

    @Autowired
    public OrderUseCase(final OrderDataProvider orderDataProvider) {
        this.orderDataProvider = orderDataProvider;
    }

    public List<OrderHttp> listAll() {
        return OrderMapper.entityToHttp(orderDataProvider.listAll());
    }

    public OrderHttp findById(Long id) throws HandlerValidationException {
        return OrderMapper.entityToHttp(orderDataProvider.findById(id));
    }

    public OrderHttp saveUpdate(OrderHttp orderHttp, boolean update) {
        return OrderMapper.entityToHttp(
                orderDataProvider.saveOrUpdate(orderHttp, update));
    }

    public void delete(Long id) {
        orderDataProvider.deleteById(id);
    }

}
