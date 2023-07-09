package com.daou.order.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderItemRequest {

    @ApiModelProperty(notes = "상품 코드")
    private String productCode;
    @ApiModelProperty(notes = "상품 기본 금액")
    private long productPrice;

    @ApiModelProperty(notes = "상품 수량")
    private long productQuantity;

    @Builder
    public OrderItemRequest(String productCode, long productPrice, long productQuantity) {
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
}
