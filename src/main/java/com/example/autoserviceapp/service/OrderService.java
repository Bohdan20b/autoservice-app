package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Commodity;
import com.example.autoserviceapp.model.Order;
import java.math.BigDecimal;

public interface OrderService {
    Order add(Order order);

    Order addCommodity(Long id, Commodity commodity);

    Order update(Order order);

    Order updateStatus(Long id, Order.Status status);

    BigDecimal countPrice(Long id);
}
