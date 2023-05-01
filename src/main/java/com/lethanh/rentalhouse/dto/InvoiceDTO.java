package com.lethanh.rentalhouse.dto;

import com.lethanh.rentalhouse.model.TenantModel;
import lombok.Data;

@Data
public class InvoiceDTO {
    private Long houseId;
    private Long roomId;
    private Long paymentMethodId;
    private Long tenantId;
    private String creator;
    private TenantDTO tenantDTO;

}
