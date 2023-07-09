package com.daou.product.model.response;

import com.daou.product.domain.Product;
import com.daou.product.domain.ProductOption;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponse {

    private long id;
    @ApiModelProperty(notes = "상품 코드")
    private String code;
    @ApiModelProperty(notes = "상품 브랜드")
    private String brand;
    @ApiModelProperty(notes = "상품명")
    private String name;
    @ApiModelProperty(notes = "상품 요약")
    private String summary;
    @ApiModelProperty(notes = "상품 재고")
    private int inventory;
    @ApiModelProperty(notes = "상품 기본 금액")
    private long price;
    @ApiModelProperty(notes = "상품 정보")
    private String content;

    @ApiModelProperty(notes = "상품 이미지")
    private String imgUrl;

    @ApiModelProperty(notes = "상품 옵션")
    private List<ProductOption> productOptionList;

    public ProductResponse(long id, String code, String brand, String name, String summary, int inventory,
                           long price, String content, String imgUrl, List<ProductOption> productOptionList) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.summary = summary;
        this.inventory = inventory;
        this.price = price;
        this.content = content;
        this.imgUrl = imgUrl;
        this.productOptionList = productOptionList;
    }

    public ProductResponse(Product product) {
        this.brand = product.getBrand();
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.summary = product.getSummary();
        this.inventory = product.getInventory();
        this.price = product.getPrice();
        this.content = product.getContent();
        this.imgUrl = product.getImgUrl();
        this.productOptionList = product.getProductOptions();
    }

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getCode(), product.getBrand(),
                product.getName(), product.getSummary(), product.getInventory(), product.getPrice(),
                product.getContent(), product.getImgUrl(), product.getProductOptions());
    }
}
