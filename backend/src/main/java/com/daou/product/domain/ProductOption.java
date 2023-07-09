package com.daou.product.domain;

import com.daou.product.constant.OptionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class ProductOption {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "opt_code")
    private Long id; // 옵션 id

    @Enumerated(EnumType.STRING)
    @Column(name="opt_type")
    private OptionType type; //추가 옵션 구분 (추가 상품 add / 옵션 option)

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Product product; // 상품 양방향 매핑

    @Column(name = "opt_name")
    private String name; //옵션 이름

    @Column(name= "opt_price")
    private int price;

    public static ProductOption createOption( OptionType type, Product product, String name, int price) {
        ProductOption productOption = new ProductOption();
        productOption.setType(type);
        productOption.setProduct(product);
        productOption.setName(name);
        productOption.setPrice(price);

        return productOption;
    }

}
