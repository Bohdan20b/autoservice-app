package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Commodity;
import com.example.autoserviceapp.repository.CommodityRepository;
import com.example.autoserviceapp.service.CommodityService;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {
    private final CommodityRepository commodityRepository;

    public CommodityServiceImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public Commodity add(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    @Override
    public Commodity update(Commodity commodity) {
        return commodityRepository.save(commodity);
    }
}
