package com.example.autoserviceapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;
    private String problem;
    @Column(name = "accept_time")
    private LocalDateTime acceptTime;
    @OneToMany
    @JoinTable(name = "order_services",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ServiceObject> serviceList;
    @OneToMany
    @JoinTable(name = "orders_commodities",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "commodity_id"))
    private List<Commodity> commodityList;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal price;
    @Column(name = "complete_time")
    private LocalDateTime completeTime;

    public enum Status {
        ACCEPTED("Order is accepted."),
        PROCESSING("Order is processing."),
        SUCCESSFUL("Order is successful."),
        UNSUCCESSFUL("Order is unsuccessful."),
        PAID("Order is paid.");
        private String statusResponse;

        Status(String statusResponse) {
            this.statusResponse = statusResponse;
        }
    }
}
