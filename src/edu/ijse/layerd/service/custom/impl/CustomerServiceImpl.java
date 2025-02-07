/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.service.custom.impl;

import edu.ijse.layerd.dao.DaoFactory;
import edu.ijse.layerd.dao.custom.CustomerDao;
import edu.ijse.layerd.dto.CustomerDto;
import edu.ijse.layerd.entity.CustomerEntity;
import edu.ijse.layerd.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
 public class CustomerServiceImpl implements CustomerService{

     private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);
     
    @Override
    public CustomerDto search(String customerId) throws Exception {
        CustomerEntity customerEntity = customerDao.search(customerId);
        if(customerEntity != null){
             CustomerDto dto = new CustomerDto(customerEntity.getId(),
                    customerEntity.getTitle(), customerEntity.getName(),
                    customerEntity.getDob(), 
                    customerEntity.getSalary(), customerEntity.getAddress(), customerEntity.getCity(),
                    customerEntity.getProvince(), customerEntity.getPostalCode());
            return dto;
        }
        
        return null;
    }

  @Override
    public String save(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(customerDto.getId(),
                customerDto.getTitle(), customerDto.getName(), customerDto.getDob(), customerDto.getSalary(),
                customerDto.getAddress(),customerDto.getCity(), 
                customerDto.getProvince(), customerDto.getPostalCode());
        return customerDao.save(customerEntity) ? "Success" : "Fail";
    }

    public String Update(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(customerDto.getId(),
                customerDto.getTitle(), customerDto.getName(), customerDto.getDob(), customerDto.getSalary(),
                customerDto.getAddress(),customerDto.getCity(), 
                customerDto.getProvince(), customerDto.getPostalCode());
        return customerDao.update(customerEntity) ? "Success" : "Fail";    }

    public String Delete(String customerId) throws Exception {
        return customerDao.delete(customerId) ? "Success" : "Fail";
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        ArrayList<CustomerEntity> customerEntitys = customerDao.getAll();
        for (CustomerEntity customerEntity : customerEntitys) {
            CustomerDto dto = new CustomerDto(customerEntity.getId(),
                    customerEntity.getTitle(), customerEntity.getName(),
                    customerEntity.getDob(), 
                    customerEntity.getSalary(), customerEntity.getAddress(), customerEntity.getCity(),
                    customerEntity.getProvince(), customerEntity.getPostalCode());
            customerDtos.add(dto);
        }
        return customerDtos;
    }  

   
}
