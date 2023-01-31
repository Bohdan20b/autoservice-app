package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.model.ServiceObject.ServiceStatus;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.service.MasterService;
import com.example.autoserviceapp.service.ServiceObjectService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private static final double COEFFICIENT = 0.4;
    private final MasterRepository masterRepository;
    private final ServiceObjectService serviceObjectService;

    public MasterServiceImpl(MasterRepository masterRepository,
            ServiceObjectService serviceObjectService) {
        this.masterRepository = masterRepository;
        this.serviceObjectService = serviceObjectService;
    }

    @Override
    public Master add(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public List<Order> getOrdersList(Long id) {
        return masterRepository.getReferenceById(id).getCompleteOrders();
    }

    @Override
    public BigDecimal countSalary(Long id) {
        List<ServiceObject> serviceList = serviceObjectService
                .getAllByMasterIdAndStatus(id, ServiceObject.ServiceStatus.UNPAID);
        BigDecimal salary = serviceList.stream()
                .map(ServiceObject::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal(COEFFICIENT));
        serviceList.forEach(service -> serviceObjectService
                .updateServiceStatus(service.getId(),ServiceStatus.PAID));
        return salary;
    }
}
