package com.daou.product.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductRequest {

    @ApiModelProperty(notes = "상품 브랜드")
    private String brand;

    @ApiModelProperty(notes = "상품명")
    private String name;
    @ApiModelProperty(notes = "상품 요약정보")
    private String summary;
    @ApiModelProperty(notes = "상품 세부정보")
    private String content;
    @ApiModelProperty(notes = "상품 기본 금액")
    private int price;
    @ApiModelProperty(notes = "상품 총 재고")
    private int inventory;

    @ApiModelProperty(notes = "상품 이미지 정보")
    private String imgUrl;

    @Builder
    public ProductRequest(String brand, String name, String summary, String content,
                          int price, int inventory, String imgUrl) {
        this.brand = brand;
        this.name = name;
        this.summary = summary;
        this.content = content;
        this.price = price;
        this.inventory = inventory;
        this.imgUrl = imgUrl;
    }
}
