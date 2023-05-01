package com.lethanh.rentalhouse.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class GenericModel implements Serializable {
    @Temporal(TemporalType.DATE)
    @Column(name = "createdDate", nullable = true, updatable = false)
    @CreatedDate
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "modifiedDate", nullable = true)
    @LastModifiedDate
    private Date modifiedDate;
//    private String createdBy;
//    private String modifiedBy;
}
