package com.lethanh.rentalhouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;

@Entity
@Table(name = "room")
@Data
public class RoomModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private int floor;
    private String area;
    @Column(nullable = true)
    private int currentTenants;
    @Column(nullable = true)
    private int currentMax;
    @Column(nullable = true)
    private Boolean status;
    @ColumnDefault("0")
    private int rents;
    private String description;

    @ColumnDefault("0")
    @Column(nullable = true)
    private int totalPrice;

    @ManyToMany
    @JoinTable(name = "room_service", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    @JsonIgnoreProperties("rooms")
    private Collection<ServiceModel> services;
    @ManyToOne
    @JoinColumn(name = "house_id",referencedColumnName = "id")
    @JsonBackReference
//    @JsonIgnoreProperties("rooms")
    private HouseModel house;

    @ManyToMany(mappedBy = "roomList")
    @JsonIgnoreProperties("roomList")
    private Collection<TenantModel> tenantList;

}
