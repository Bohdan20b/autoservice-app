package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.model.ServiceObject.ServiceStatus;
import com.example.autoserviceapp.repository.ServiceRepository;
import com.example.autoserviceapp.service.ServiceObjectService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceObjectServiceImpl implements ServiceObjectService {
    private final ServiceRepository serviceRepository;

    public ServiceObjectServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceObject add(ServiceObject service) {
        return serviceRepository.save(service);
    }

    @Override
    public ServiceObject update(ServiceObject service) {
        return serviceRepository.save(service);
    }

    @Override
    public ServiceObject updateServiceStatus(Long id, ServiceStatus status) {
        ServiceObject service = serviceRepository.getReferenceById(id);
        service.setStatus(status);
        return update(service);
    }

    @Override
    public List<ServiceObject> getAllByMasterIdAndStatus(Long masterId, ServiceStatus status) {
        return serviceRepository.getAllByMasterIdAndStatus(masterId, status);
    }
}
