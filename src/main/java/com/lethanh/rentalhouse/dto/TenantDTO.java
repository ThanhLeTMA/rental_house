package com.lethanh.rentalhouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Collection;

@Data
public class TenantDTO {
    private Long id;
    private String name;
    @JsonIgnoreProperties("tenants")
    private Collection<RoomDTO> roomList;
    private InvoiceDTO invoiceDTO;
}
