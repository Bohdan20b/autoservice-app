package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import java.util.List;

public interface OwnerService {
    Owner add(Owner owner);

    Owner update(Owner owner);

    List<Order> getOrdersList(Long id);
}
