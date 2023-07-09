package com.daou.customer.service;

import com.daou.customer.model.CustomerResponse;

public interface CustomerService {
    CustomerResponse findCustomer(Long CustomerId);
}
