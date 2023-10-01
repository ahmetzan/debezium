package com.example.debezium.controller;

import com.example.debezium.request.CustomerSaveRequest;
import com.example.debezium.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public void save (@RequestBody CustomerSaveRequest customerSaveRequest) {
        customerService.saveOrUpdate(customerSaveRequest);
    }

    @DeleteMapping("{id}/delete")
    public void delete (@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @PostMapping("/bulk")
    public int createBulkCustomer() {
        return customerService.bulkSave();
    }
}
