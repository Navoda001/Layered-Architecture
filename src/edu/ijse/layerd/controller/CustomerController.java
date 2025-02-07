/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.controller;

import edu.ijse.layerd.dto.CustomerDto;
import edu.ijse.layerd.service.ServiceFactory;
import edu.ijse.layerd.service.custom.CustomerService;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public class CustomerController {
    CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
     public CustomerDto searchCustomer(String id) throws Exception{
        return customerService.search(id);
    }
    
    public String save(CustomerDto dto) throws Exception{
        return customerService.save(dto);
    }
    
     public String update(CustomerDto dto) throws Exception{
        return customerService.Update(dto);
    }
    
    public String delete(String id) throws Exception{
        return customerService.Delete(id);
    }
    
    public ArrayList<CustomerDto> getAll() throws Exception{
        return customerService.getAll();
    }
}
