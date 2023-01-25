package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
