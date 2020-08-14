package com.altimetrik.foodfanda.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@Builder(toBuilder = true)
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    private UUID uuid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_PURCHASE_ORDER")
    private PurchaseOrder purchaseOrder;
}
