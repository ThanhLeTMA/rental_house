package com.lethanh.rentalhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;



import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "house")
@Data
public class HouseModel extends GenericModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String street;
    @Column(name = "establishdate")
    private Date establishDate;
    @Column(name = "totalroom")
    private int totalRoom;
    private int totalRoomPrice;
    private String manager;
    @Column(nullable = true)
    private boolean status;
    @JsonIgnoreProperties("house")
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    Collection<RoomModel> rooms;


}
