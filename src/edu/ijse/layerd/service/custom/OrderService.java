/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layerd.service.custom;

import edu.ijse.layerd.dto.OrderDto;
import edu.ijse.layerd.service.SuperService;

/**
 *
 * @author Navoda Chathurya
 */
public interface OrderService extends SuperService{
    
    String PlaceOrder(OrderDto orderDto)throws Exception;
    
}
