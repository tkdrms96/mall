package com.daou.customer.service;

import com.daou.customer.domain.Customer;
import com.daou.customer.model.CustomerResponse;
import com.daou.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse findCustomer(Long CustomerId) {
        Customer customer = customerRepository.findById(CustomerId).orElseThrow();

        CustomerResponse response = CustomerResponse.builder().customer(customer).build();

        return response;
    }
}
