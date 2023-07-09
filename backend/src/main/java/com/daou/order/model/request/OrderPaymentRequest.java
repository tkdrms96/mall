package com.daou.order.model.request;

import com.daou.order.domain.Payment;
import com.daou.common.type.CardType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
public class OrderPaymentRequest {

    @ApiModelProperty(notes = "전체 상품의 총 금액 (할인금 제외)")
    private long totalPrice;

    @ApiModelProperty(notes = "전체 상품의 총 할인금")
    private long discountPrice;
    @ApiModelProperty(notes = "결제타입 ? 신용카드 : 현금")
    private Payment.PayType payType;
    @ApiModelProperty(notes = "카드타입 ? 비자 : 마스터")
    @Nullable
    private CardType cardType;
    @ApiModelProperty(notes = "할부여부 ? 할부 : 일시불")
    private boolean installment;
    @ApiModelProperty(notes = "할부 개월 수")
    private int monthlyInstallment;

    @Builder
    public OrderPaymentRequest(long totalPrice, long discountPrice, Payment.PayType payType,
                               CardType cardType, boolean installment, int monthlyInstallment) {
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.payType = payType;
        this.cardType = cardType;
        this.installment = installment;
        this.monthlyInstallment = monthlyInstallment;
    }
}
