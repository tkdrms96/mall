package com.daou.order.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class OrderRequest {

    @ApiModelProperty(notes = "배송정보 -> 주문서와 연관된 배송 테이블에 저장")
    private OrderReceiverRequest orderReceiver;

    @ApiModelProperty(notes = "결제 -> 주문서와 연관된 결제 테이블에 저장")
    private OrderPaymentRequest orderPayment;

    @ApiModelProperty(notes = "상품 목록")
    private List<OrderItemRequest> orderItems;

    @Builder
    public OrderRequest(OrderReceiverRequest orderReceiver, OrderPaymentRequest orderPayment,
                        List<OrderItemRequest> orderItems) {
        this.orderReceiver = orderReceiver;
        this.orderPayment = orderPayment;
        this.orderItems = orderItems;
    }

    public long getTotalByDiscount() {
        return this.orderPayment.getTotalPrice() - this.orderPayment.getDiscountPrice();
    }
}
