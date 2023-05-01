package com.lethanh.rentalhouse.controller.manager;

import com.lethanh.rentalhouse.model.TenantModel;
import com.lethanh.rentalhouse.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager/tenant")
public class TenantController {
    @Autowired
    TenantService tenantService;

    @GetMapping(value = {"/getTenants","/{tenant_id}"})
    public List<TenantModel> getTenantDetails(@PathVariable(required = false) Long tenant_id) {
        return tenantService.getTenantDetails(tenant_id);
    }
    @GetMapping("/tenant/{id}")
    public Optional<TenantModel> viewTenantDetail(@PathVariable Long id){
        return tenantService.viewTenantDetail(id);
    }
    @PostMapping("/save")
    public TenantModel createTenant(@RequestBody TenantModel tenantModel){
        return tenantService.createTenant(tenantModel);
    }
    @PutMapping("/{tenant_id}/room/{room_id}")
    public TenantModel assignRoomToTenant(@PathVariable Long tenant_id, @PathVariable Long room_id){
        return tenantService.assignRoomToTenant(tenant_id,room_id);
    }
}
