package com.lethanh.rentalhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Collection;

@Entity
@Table(name = "service")
@Data
public class ServiceModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ColumnDefault("0")
    private int price;
    @ManyToMany(mappedBy = "services")
    @JsonIgnoreProperties("services")
    private Collection<RoomModel> rooms;
}
