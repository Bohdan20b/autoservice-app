package com.example.autoserviceapp.service.impl;


import com.example.autoserviceapp.model.ServiceObject;
import com.example.autoserviceapp.model.ServiceObject.ServiceStatus;
import com.example.autoserviceapp.service.ServiceObjectService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MasterServiceImplTest {
    @InjectMocks
    private MasterServiceImpl masterService;

    @Mock
    private ServiceObjectService serviceObjectService;

    @Test
    void countSalary() {
        Long masterId = 1L;
        ServiceObject.ServiceStatus serviceStatus = ServiceStatus.UNPAID;
        ServiceObject firstService = new ServiceObject();
        firstService.setPrice(new BigDecimal(500));
        ServiceObject secondService = new ServiceObject();
        secondService.setPrice(new BigDecimal(100));
        Mockito.when(serviceObjectService.getAllByMasterIdAndStatus(masterId, serviceStatus))
                .thenReturn(List.of(firstService, secondService));
        BigDecimal expected = new BigDecimal("240.00");
        BigDecimal actual = masterService.countSalary(masterId);
        Assertions.assertEquals(expected, actual.round(new MathContext(5)));
    }
}

