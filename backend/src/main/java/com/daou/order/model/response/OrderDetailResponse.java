package com.daou.order.model.response;

import com.daou.order.domain.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderDetailResponse {

    private long id;

    @ApiModelProperty(notes = "주문번호")
    private String code;

    @ApiModelProperty(notes = "결제 일자")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime paymentDate;

    @ApiModelProperty(notes = "결제 금액")
    private long totalPrice;

    @ApiModelProperty(notes = "주문 메세지")
    private String message;

    public OrderDetailResponse(long id, String code, LocalDateTime paymentDate,
                               long totalPrice, String message) {
        this.id = id;
        this.code = code;
        this.paymentDate = paymentDate;
        this.totalPrice = totalPrice;
        this.message = message;
    }

    public static OrderDetailResponse of(Order order, String message) {
        return new OrderDetailResponse(order.getId(), order.getCode(), order.getCreatedAt(),
                order.getPayment().getTotalPrice(), message);
    }
}
