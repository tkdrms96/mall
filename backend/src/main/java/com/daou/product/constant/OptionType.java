package com.daou.product.constant;


import lombok.Getter;

@Getter
public enum OptionType {
    ADD("추가상품"), OPTION("옵션");

    private final String option;
    OptionType(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
