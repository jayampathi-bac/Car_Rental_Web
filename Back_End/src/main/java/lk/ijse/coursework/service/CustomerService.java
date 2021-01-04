package lk.ijse.coursework.service;


import lk.ijse.coursework.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto dto);

    void updateCustomer(CustomerDto dto);

    CustomerDto searchCustomer(String id);

    void deleteCustomer(String id);

    List<CustomerDto> getAllCustomers();

    String createCustomerId();
}
