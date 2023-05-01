package com.lethanh.rentalhouse.controller.manager;

import com.lethanh.rentalhouse.dto.InvoiceDTO;
import com.lethanh.rentalhouse.model.InvoiceModel;
import com.lethanh.rentalhouse.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manager/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService  invoiceService;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping("/all")
    public List<InvoiceDTO> viewAllInvoices(){
        return invoiceService.viewAllInvoices().stream().map(invoiceModel -> modelMapper.map(invoiceModel, InvoiceDTO.class)).collect(Collectors.toList());
    }
    @GetMapping(value = {"/getInvoices","/{invoice_id}"})
    public List<InvoiceModel> getInvoiceDetails(@PathVariable(required = false) Long invoice_id){
        return invoiceService.getInvoiceDetails(invoice_id);
//        return invoiceService.getInvoiceDetails(invoice_id).stream().map(invoiceModel -> modelMapper.map(invoiceModel, InvoiceDTO.class)).collect(Collectors.toList());
    }
    @PostMapping("/save")
    public InvoiceModel createInvoice(@RequestBody InvoiceModel invoiceModel){
        return invoiceService.saveInvoice(invoiceModel);
    }
    @PutMapping("/{invoice_id}/tenant/{tenant_id}")
    public InvoiceModel assignInvoiceToTenant(@PathVariable Long invoice_id, @PathVariable Long tenant_id){
        return invoiceService.assignInvoiceToTenant(invoice_id,tenant_id);
    }

}
