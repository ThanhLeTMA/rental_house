package com.lethanh.rentalhouse.model;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "employee")
public class EmployeeModel extends GenericModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthdate;
    private int gender;
    private Long phone;
    private  String email;
    private  int idNumber;
    private Long house_id;
    private int position;
    private Long account_id;
    private Date startDate;
    private int status;
    private String description;
}
