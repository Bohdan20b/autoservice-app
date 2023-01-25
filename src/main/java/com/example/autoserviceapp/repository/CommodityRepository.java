package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
}
