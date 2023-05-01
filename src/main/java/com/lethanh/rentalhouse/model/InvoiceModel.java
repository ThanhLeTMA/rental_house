package com.lethanh.rentalhouse.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "invoice")
@Getter
@Setter
public class InvoiceModel extends GenericModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long houseId;

    private Long roomId;

    private Long paymentMethodId;


    private Long phone;

    private String email;

    private String creator;

    private Date closingDate;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @JsonManagedReference
    private TenantModel tenant;
}
