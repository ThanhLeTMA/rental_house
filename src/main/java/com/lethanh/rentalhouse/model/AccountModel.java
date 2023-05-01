package com.lethanh.rentalhouse.model;

import jakarta.persistence.*;
import lombok.Data;

//import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
public class AccountModel extends GenericModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String rePassword;
    private Long role_id;
}
