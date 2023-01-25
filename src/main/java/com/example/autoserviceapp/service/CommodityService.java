package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.Commodity;

public interface CommodityService {
    Commodity add(Commodity commodity);

    Commodity update(Commodity commodity);
}
