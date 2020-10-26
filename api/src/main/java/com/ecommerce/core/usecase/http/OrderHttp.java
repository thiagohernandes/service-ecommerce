package com.ecommerce.core.usecase.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderHttp {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("datebuy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateBuy;
    @JsonProperty("customer")
    private CustomerHttp customer;
    @JsonProperty("itens")
    private List<ItemOrderHttp> itens;

}
