package com.lethanh.rentalhouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "tenant")
@Data
public class TenantModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthdate;
    private int gender;
    private Long phone;
    private String email;
    private int idnumber;

    private String address;

    private Date rentDate;

    private int status;
    private int totalFee;

    private String description;

    @ManyToMany
    @JoinTable(name = "tenant_room", joinColumns = @JoinColumn(name = "tenant_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
    @JsonIgnoreProperties("tenantList")
    private Collection<RoomModel> roomList;

    @OneToOne(mappedBy = "tenant",cascade=CascadeType.ALL)
    @JsonBackReference
    private InvoiceModel invoice;
}
