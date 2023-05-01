package com.lethanh.rentalhouse;

import com.lethanh.rentalhouse.model.InvoiceModel;
import com.lethanh.rentalhouse.model.TenantModel;
import com.lethanh.rentalhouse.repository.TenantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TestCreateInvoice {
    @Autowired
    TenantRepository tenantRepository;

    @Test
    public void testCreateInvoice(){


        InvoiceModel invoiceModel = new InvoiceModel();

        invoiceModel.setEmail("thanh@gmail.com");

        TenantModel tenantModel = new TenantModel();
        tenantModel.setInvoice(invoiceModel);
        invoiceModel.setTenant(tenantModel);
        tenantModel.setName("thanh");

        TenantModel tenantModel1 = tenantRepository.save(tenantModel);
        Assertions.assertNotNull(tenantModel1);
    }
}
