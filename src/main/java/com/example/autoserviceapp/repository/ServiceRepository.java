package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.ServiceObject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceObject, Long> {
    List<ServiceObject> getAllByMasterIdAndStatus(Long masterId, ServiceObject.ServiceStatus status);
}
