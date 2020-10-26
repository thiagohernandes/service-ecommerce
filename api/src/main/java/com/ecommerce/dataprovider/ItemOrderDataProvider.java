package com.ecommerce.dataprovider;

import com.ecommerce.core.handler.exception.HandlerValidationException;
import com.ecommerce.dataprovider.constants.Constants;
import com.ecommerce.dataprovider.entity.ItemOrderEntity;
import com.ecommerce.dataprovider.gateway.ItemOrderGateway;
import com.ecommerce.dataprovider.repository.ItemOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ItemOrderDataProvider implements ItemOrderGateway {

    private final ItemOrderRepository itemOrderRepository;

    @Autowired
    public ItemOrderDataProvider(final ItemOrderRepository itemOrderRepository) {
        this.itemOrderRepository = itemOrderRepository;
    }

    public List<ItemOrderEntity> listAll() {
        return itemOrderRepository.findAll();
    }

    public List<ItemOrderEntity> listAllByOrderId(Long orderId) {
        return itemOrderRepository.listAllByOrderId(orderId);
    }

    public ItemOrderEntity findById(Long id) throws HandlerValidationException {
        Optional<ItemOrderEntity> itemOrderEntity = itemOrderRepository.findById(id);
        if(itemOrderEntity.isPresent()) {
            return itemOrderEntity.get();
        } else {
            log.error(Constants.msgNaoEncontrado);
            throw new HandlerValidationException(Constants.msgNaoEncontrado);
        }
    }

    @Transactional
    public ItemOrderEntity saveOrUpdate(ItemOrderEntity itemOrderEntity, boolean update) {
        if (update) {
            final ItemOrderEntity itemOrderEntityUpdated = itemOrderRepository.findById(itemOrderEntity.getId()).get();
            itemOrderEntityUpdated.setIdproduct(itemOrderEntity.getIdproduct());
            itemOrderEntityUpdated.setPrice(itemOrderEntity.getPrice());
            itemOrderEntityUpdated.setQuantity(itemOrderEntity.getQuantity());
            return itemOrderRepository.saveAndFlush(itemOrderEntityUpdated);
        }
        return itemOrderRepository.saveAndFlush(itemOrderEntity);
    }

    public void deleteById(Long id) {
        itemOrderRepository.deleteById(id);
    }
}
