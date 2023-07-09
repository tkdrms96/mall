package com.daou.order.model.response;

import com.daou.order.domain.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderResponse {

    private long id;

    @ApiModelProperty(notes = "주문번호")
    private String code;

    public OrderResponse(long id, String code) {
        this.id = id;
        this.code = code;
    }

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getCode());
    }
}
