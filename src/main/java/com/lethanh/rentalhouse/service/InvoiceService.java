package com.lethanh.rentalhouse.service;

import com.lethanh.rentalhouse.model.InvoiceModel;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    InvoiceModel saveInvoice(InvoiceModel invoiceModel);

    InvoiceModel updateInvoice(InvoiceModel invoiceModel);

    List<InvoiceModel> getInvoiceDetails(Long id);

    void deleteInvoice(Long id);

    List<InvoiceModel> viewAllInvoices();

    InvoiceModel assignInvoiceToTenant(Long invoice_id, Long tenant_id);
}
