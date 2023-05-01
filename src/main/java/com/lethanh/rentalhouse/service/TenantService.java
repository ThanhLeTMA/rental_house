package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.model.TenantModel;

import java.util.List;
import java.util.Optional;

public interface TenantService {
    TenantModel createTenant(TenantModel tenantModel);
    TenantModel updateTenant(TenantModel tenantModel);
    List<TenantModel> viewAllTenants();
    Optional<TenantModel> viewTenantDetail(Long id);

    List<TenantModel> getTenantDetails(Long id);
    TenantModel assignRoomToTenant(Long tenant_id, Long room_id);
    int calculateTotalFee(Long tenant_id);

}
