package com.lethanh.rentalhouse.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "paymentmethod")
@Data
public class PaymentMethodModel extends GenericModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

}
