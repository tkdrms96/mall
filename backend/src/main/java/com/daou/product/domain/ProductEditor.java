package com.daou.product.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Lob;

@Getter
public class ProductEditor {
    private String brand;
    private String name;
    private String summary;
    private int inventory; //재고
    private long price;
    @Lob
    private String content; //상품 상세 설명을 위한 @Lob

    @Builder
    public ProductEditor(String brand, String name, String summary, int inventory,
                         String content, long price) {
        this.brand = brand;
        this.name = name;
        this.summary = summary;
        this.inventory = inventory;
        this.content = content;
        this.price = price;
    }
}
