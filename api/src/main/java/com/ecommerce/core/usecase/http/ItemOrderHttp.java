package com.ecommerce.core.usecase.http;

import com.ecommerce.dataprovider.entity.OrderEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemOrderHttp {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("idproduct")
    private Long idproduct;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("idorder")
    private Long idorder;

}
