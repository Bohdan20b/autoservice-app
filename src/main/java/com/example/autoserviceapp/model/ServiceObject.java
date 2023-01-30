package com.example.autoserviceapp.model;


import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "services")
public class ServiceObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private Master master;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    public enum ServiceStatus {
        PAID("Service is paid."),
        UNPAID("Service is not paid");
        private String statusResponse;

        ServiceStatus(String statusResponse) {
            this.statusResponse = statusResponse;
        }
    }
}
