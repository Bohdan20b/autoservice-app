package com.example.autoserviceapp.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
