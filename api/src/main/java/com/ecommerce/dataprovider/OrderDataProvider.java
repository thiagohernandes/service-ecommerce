package com.ecommerce.dataprovider;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.core.usecase.http.OrderHttp;
import com.ecommerce.dataprovider.constants.Constants;
import com.ecommerce.dataprovider.entity.OrderEntity;
import com.ecommerce.dataprovider.gateway.OrderGateway;
import com.ecommerce.dataprovider.mapper.CustomerMapper;
import com.ecommerce.dataprovider.mapper.ItemOrderMapper;
import com.ecommerce.dataprovider.mapper.OrderMapper;
import com.ecommerce.dataprovider.repository.ItemOrderRepository;
import com.ecommerce.dataprovider.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrderDataProvider implements OrderGateway {

    private final OrderRepository orderRepository;
    private final ItemOrderRepository itemOrderRepository;

    @Autowired
    public OrderDataProvider(final OrderRepository orderRepository,
                             final ItemOrderRepository itemOrderRepository) {
        this.orderRepository = orderRepository;
        this.itemOrderRepository = itemOrderRepository;
    }

    public List<OrderEntity> listAll() {
        List<OrderEntity> listOrder = orderRepository.findAll();
        listOrder.stream().forEach(orderEntity ->
                orderEntity.setItens(itemOrderRepository.listAllByOrderId(orderEntity.getId())));
        return listOrder;
    }

    public OrderEntity findById(Long id) throws HandlerValidationException {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if(orderEntity.isPresent()) {
            orderEntity.get().setItens(itemOrderRepository.listAllByOrderId(id));
            return orderEntity.get();
        } else {
            log.error(Constants.msgNaoEncontrado);
            throw new HandlerValidationException(Constants.msgNaoEncontrado);
        }
    }

    @Transactional
    public OrderEntity saveOrUpdate(OrderHttp orderHttp, boolean update) {
        if (update) {
            return makeOrderUpdate(orderHttp);
        }
        return makeOrderSave(orderHttp);
    }

    @Transactional
    public void deleteById(Long id) {
        itemOrderRepository.deleteByOrderId(id);
        orderRepository.deleteById(id);
    }

    private final OrderEntity makeOrderSave(OrderHttp orderHttp) {
        OrderEntity orderSaved = orderRepository.saveAndFlush(OrderMapper.httpToEntity(orderHttp));
        orderHttp.getItens().stream().forEach(item -> item.setIdorder(orderSaved.getId()));
        itemOrderRepository.saveAll(ItemOrderMapper.httpToEntity(orderHttp.getItens()));
        return orderSaved;
    }

    private final OrderEntity makeOrderUpdate(OrderHttp orderHttp){
        itemOrderRepository.deleteByOrderId(orderHttp.getId());
        OrderEntity orderEntityUpdated = orderRepository.findById(orderHttp.getId()).get();
        orderEntityUpdated.setCustomer(CustomerMapper.httpToEntity(orderHttp.getCustomer()));
        orderEntityUpdated.setDateBuy(orderHttp.getDateBuy());
        orderHttp.getItens().stream().forEach(item -> item.setIdorder(orderEntityUpdated.getId()));
        orderEntityUpdated.setItens(ItemOrderMapper.httpToEntity(orderHttp.getItens()));
        itemOrderRepository.saveAll(ItemOrderMapper.httpToEntity(orderHttp.getItens()));
        return orderRepository.saveAndFlush(orderEntityUpdated);
    }

}
