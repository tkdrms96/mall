package com.daou.order.repository;

import com.daou.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByCustomerIdAndCode(Long customerId, String code);
}
