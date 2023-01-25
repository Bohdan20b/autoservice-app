package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface MasterService {
    Master add(Master master);

    Master update(Master master);

    List<Order> getOrdersList(Long id);

    BigDecimal countSalary(Long id);
}
