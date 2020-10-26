package com.ecommerce.dataprovider.repository;

import com.ecommerce.dataprovider.entity.ItemOrderEntity;
import com.ecommerce.dataprovider.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {

    @Query(value = " SELECT i.* FROM itensorders i WHERE i.idorder = :idorder ", nativeQuery = true)
    List<ItemOrderEntity> listAllByOrderId(@Param("idorder") Long idorder);

    @Modifying
    @Query(value = " DELETE FROM itensorders i WHERE i.idorder = :idorder ", nativeQuery = true)
    void deleteByOrderId(@Param("idorder") Long idorder);

}
