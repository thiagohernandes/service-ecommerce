package com.ecommerce.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datebuy", nullable = false)
    private LocalDate dateBuy;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcustomer")
    private CustomerEntity customer;
    @Transient
    private List<ItemOrderEntity> itens;

}
