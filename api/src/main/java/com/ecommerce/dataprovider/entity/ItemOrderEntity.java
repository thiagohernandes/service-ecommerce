package com.ecommerce.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "itensorders")
@Builder
public class ItemOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "idproduct", nullable = false)
    private Long idproduct;
    @Column(name = "idorder", nullable = false)
    private Long idorder;

}
