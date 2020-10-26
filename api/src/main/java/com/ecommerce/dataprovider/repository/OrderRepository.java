package com.ecommerce.dataprovider.repository;

import com.ecommerce.dataprovider.entity.OrderEntity;
import com.ecommerce.dataprovider.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
