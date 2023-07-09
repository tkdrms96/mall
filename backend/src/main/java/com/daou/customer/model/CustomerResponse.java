package com.daou.customer.model;

import com.daou.customer.domain.Address;
import com.daou.customer.domain.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerResponse {

    private long id;
    @ApiModelProperty(notes = "사용자 아이디")
    private String customerId;
    @ApiModelProperty(notes = "사용자 이름")
    private String name;
    @ApiModelProperty(notes = "핸드폰 번호")
    private String mobile;
    @ApiModelProperty(notes = "이메일")
    private String email;
    @ApiModelProperty(notes = "활성화 여부")
    private boolean active;
    @ApiModelProperty(notes = "배송지 목록")
    private List<Address> addresses;

    @ApiModelProperty(notes = "사용자 프로필 이미지 경로")
    private String profileUrl;

    @Builder
    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.customerId = customer.getCustomerId();
        this.name = customer.getName();
        this.mobile = customer.getMobile();
        this.email = customer.getEmail();
        this.active = customer.isActive();
        this.addresses = customer.getAddresses();
        this.profileUrl = customer.getProfileUrl();
    }
}
