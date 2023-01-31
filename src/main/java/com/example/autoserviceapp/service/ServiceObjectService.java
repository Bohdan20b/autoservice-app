package com.example.autoserviceapp.service;

import com.example.autoserviceapp.model.ServiceObject;
import java.util.List;

public interface ServiceObjectService {
    ServiceObject add(ServiceObject service);

    ServiceObject update(ServiceObject service);

    ServiceObject updateServiceStatus(Long id, ServiceObject.ServiceStatus status);

    List<ServiceObject> getAllByMasterIdAndStatus(Long masterId,
            ServiceObject.ServiceStatus status);
}
