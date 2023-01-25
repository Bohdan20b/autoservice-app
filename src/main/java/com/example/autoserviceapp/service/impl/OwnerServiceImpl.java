package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.repository.OwnerRepository;
import com.example.autoserviceapp.service.OwnerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner add(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Order> getOrdersList(Long id) {
        return ownerRepository.getReferenceById(id).getOrderList();
    }
}
