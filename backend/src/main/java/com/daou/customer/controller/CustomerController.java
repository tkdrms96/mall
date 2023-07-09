package com.daou.customer.controller;

import com.daou.customer.component.AuthManager;
import com.daou.customer.model.CustomerResponse;
import com.daou.customer.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "사용자 정보 조회 API 목록")
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation(value = "사용자 정보 조회", notes = "파라미터를 넘기지 않아도 customerId=1 default 계정을 조회한다.")
    @GetMapping("/customer")
    public CustomerResponse findCustomer(HttpServletRequest request) {
        Long customerId = AuthManager.getCustomerId(request);

        return customerService.findCustomer(customerId);
    }
}
