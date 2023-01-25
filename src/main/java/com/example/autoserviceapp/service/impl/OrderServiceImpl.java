package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Commodity;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Order.Status;
import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private static final double COMMODITY_DISCOUNT_PER_ITEM = 0.01;
    private static final double SERVICE_DISCOUNT_PER_ITEM = 0.02;
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(500);
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addCommodity(Long id, Commodity commodity) {
        Order order = orderRepository.getReferenceById(id);
        order.getCommodityList().add(commodity);
        return update(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateStatus(Long id, Status status) {
        Order order = orderRepository.getReferenceById(id);
        if (status == Status.SUCCESSFUL || status == Status.UNSUCCESSFUL) {
            order.setCompleteTime(LocalDateTime.now());
        }
        order.setStatus(status);
        return update(order);
    }

    @Override
    public BigDecimal countPrice(Long id) {
        Order order = orderRepository.getReferenceById(id);
        BigDecimal resultPrice;
        int orderSize = order.getCar().getOwner().getOrderList().size();
        double commodityTotalDiscount = orderSize * COMMODITY_DISCOUNT_PER_ITEM;
        double serviceTotalDiscount = orderSize * SERVICE_DISCOUNT_PER_ITEM;
        BigDecimal commodityFinalPrice = order.getCommodityList().stream()
                .map(Commodity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal(1.0 - commodityTotalDiscount));
        if (order.getServiceList().size() > 0) {
            BigDecimal serviceFinalPrice = order.getServiceList()
                    .stream()
                    .map(ServiceObject::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .multiply(new BigDecimal(1.0 - serviceTotalDiscount));
            resultPrice = commodityFinalPrice.add(serviceFinalPrice);
        } else {
            resultPrice = commodityFinalPrice.add(DEFAULT_PRICE);
        }
        order.setPrice(resultPrice);
        update(order);
        return resultPrice;
    }
}
