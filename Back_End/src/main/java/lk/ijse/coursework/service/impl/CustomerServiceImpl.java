package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.CustomerDto;
import lk.ijse.coursework.entity.Customer;
import lk.ijse.coursework.repo.CustomerRepo;
import lk.ijse.coursework.service.CustomerService;
import lk.ijse.coursework.service.IdGenerateService;
import lk.ijse.coursework.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo repo;
    @Autowired
    UserService service;
    @Autowired
    ModelMapper mapper;

    @Autowired
    IdGenerateService idGenerateService;
    @Override
    public void saveCustomer(CustomerDto dto) {
        System.out.println("save working");
         String userId = idGenerateService.genarateCustomerId();
            System.out.println(userId);
            dto.setUserid(userId);
            dto.setStatus(1);
            System.out.println("---"+dto.getUserid());
           // System.out.println(dto.getUserid().equalsIgnoreCase(""));
        if (!repo.existsById(dto.getUserid())) {
            Customer c = mapper.map(dto, Customer.class);
            System.out.println(c.getUserid()+""+c.getIdnumber()+""+c.getName()+c.getContact());
            repo.save(c);
           // service.saveUser(new UserDto(dto.getUserid(),dto.getUsername(),dto.getPassword(),dto.getStatus()));
        } else {
            throw new RuntimeException("Customer already exist..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDto dto) {

    }

    @Override
    public CustomerDto searchCustomer(String id) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public List<CustomerDto> getAllCustomers() {

        List<Customer> all = repo.findAll();
        Iterator<Customer> cus=all.iterator();
        List<CustomerDto> dto=new ArrayList<>();
     //   Customer [] cus=new Customer[all.size()];
     while (cus.hasNext()){
         Customer next = cus.next();
         CustomerDto map = mapper.map(next, CustomerDto.class);
         map.setUsername(service.getUsernamebyId(next.getUserid()));
         System.out.println(map.getUsername()+"--"+map.getIdnumber());
         dto.add(map);
     }

       return dto;
    }

    @Override
    public String createCustomerId() {
        return idGenerateService.genarateId("C");
    }
}
