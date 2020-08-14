package com.altimetrik.foodfanda.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonSerialize
@JsonDeserialize
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private UUID id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private Address location;
    @OneToMany(mappedBy = "customer",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PurchaseOrder> purchaseOrders;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart")
    private Cart cart;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reward")
    private Reward reward;
}
