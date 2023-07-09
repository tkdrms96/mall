package com.daou.order.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderReceiverRequest {
    /**
     * 배송정보 -> 변경이 되던 안되던 주문서에만 저장
     */
    @ApiModelProperty(notes = "받는 사람")
    private String receiver;
    @ApiModelProperty(notes = "받는 사람 휴대폰번호")
    private String receiverPhoneNumber;
    @ApiModelProperty(notes = "받는 사람 주소 ")
    private String receiverAddress;
    @ApiModelProperty(notes = "배송 요청사항")
    private String requestForDelivery;

    @Builder
    public OrderReceiverRequest(String receiver, String receiverPhoneNumber, String receiverAddress, String requestForDelivery) {
        this.receiver = receiver;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receiverAddress = receiverAddress;
        this.requestForDelivery = requestForDelivery;
    }
}
