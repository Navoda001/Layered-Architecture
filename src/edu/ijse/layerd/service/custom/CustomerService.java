/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layerd.service.custom;

import edu.ijse.layerd.dto.CustomerDto;
import edu.ijse.layerd.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public interface CustomerService extends SuperService {
    public String save(CustomerDto customeDto)throws Exception;
    public String Update(CustomerDto customeDto)throws Exception;
    public String Delete(String customerId)throws Exception;
    public CustomerDto search(String customerId)throws Exception;
    public ArrayList<CustomerDto> getAll()throws Exception;
}
