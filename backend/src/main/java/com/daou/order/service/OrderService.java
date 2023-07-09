package com.daou.order.service;

import com.daou.order.model.request.OrderRequest;
import com.daou.order.model.response.OrderDetailResponse;
import com.daou.order.model.response.OrderResponse;

public interface OrderService {
    OrderResponse registerOrder(Long customerId, OrderRequest orderRequest);

    OrderDetailResponse getOrderDetails(Long customerId, String orderCode);
}
