package com.example.debezium.service.impl;

import com.example.debezium.model.entity.Customer;
import com.example.debezium.repository.CustomerRepository;
import com.example.debezium.request.CustomerSaveRequest;
import com.example.debezium.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void saveOrUpdate(CustomerSaveRequest request) {

        Customer customer = customerRepository.findById(request.getId())
                .orElseGet(Customer::new);

        customer.setName(request.getName());
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public int bulkSave() {

        List<Customer> saveList = new ArrayList<>();
        for (int i = 0 ; i<5000 ; i++) {
            Customer customer = new Customer();
            customer.setName("name+" + i);
            saveList.add(customer);
        }
        customerRepository.saveAll(saveList);
        return saveList.size();
    }
}
