package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.InvoiceModel;
import com.lethanh.rentalhouse.model.TenantModel;
import com.lethanh.rentalhouse.repository.InvoiceRepository;
import com.lethanh.rentalhouse.repository.TenantRepository;
import com.lethanh.rentalhouse.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    TenantRepository tenantRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceModel saveInvoice(InvoiceModel invoiceModel) {
        return invoiceRepository.save(invoiceModel);
    }

    @Override
    public InvoiceModel updateInvoice(InvoiceModel invoiceModel) {
        return invoiceRepository.save(invoiceModel);
    }

    @Override
    public List<InvoiceModel> getInvoiceDetails(Long id) {
        if(id != null){
            return invoiceRepository.findAllById(id);
        } else {
            return invoiceRepository.findAll();
        }
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceModel> viewAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceModel assignInvoiceToTenant(Long invoice_id, Long tenant_id) {
        TenantModel tenantModel = tenantRepository.findById(tenant_id).get();
        InvoiceModel invoiceModel = invoiceRepository.findById(invoice_id).get();
        tenantModel.setInvoice(invoiceModel);
        invoiceModel.setTenant(tenantModel);
        return invoiceRepository.save(invoiceModel);
    }
}
