package com.daou.order.controller;

import com.daou.common.controller.ApiController;
import com.daou.customer.component.AuthManager;
import com.daou.order.model.request.OrderRequest;
import com.daou.order.model.response.OrderDetailResponse;
import com.daou.order.model.response.OrderResponse;
import com.daou.order.service.OrderService;
import com.daou.product.model.response.ProductResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "주문 API 목록")
public class OrderController extends ApiController {

    private final OrderService orderService;

    @ApiOperation(value = "주문서 등록(결제)", notes = "주문서에 정보를 입력하고 결제하기 버튼을 누른다.")
    @PostMapping("/order")
    public OrderResponse registerOrder(HttpServletRequest request,
                                       @RequestBody OrderRequest orderRequest) {
        Long customerId = AuthManager.getCustomerId(request);
        return orderService.registerOrder(customerId, orderRequest);
    }

    @ApiOperation(value = "주문 결과 조회", notes = "주문 성공 시 주문 정보를 조회한다.")
    @GetMapping("/order")
    public OrderDetailResponse getOrderDetails(HttpServletRequest request,
                                               @RequestParam("orderCode") String orderCode) {
        Long customerId = AuthManager.getCustomerId(request);
        return orderService.getOrderDetails(customerId, orderCode);
    }
}

