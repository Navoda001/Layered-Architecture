  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.controller;

import edu.ijse.layerd.dto.OrderDto;
import edu.ijse.layerd.service.ServiceFactory;
import edu.ijse.layerd.service.custom.OrderService;

/**
 *
 * @author Navoda Chathurya
 */
public class OrdeController {
    private OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    public String placeOrder (OrderDto orderDto) throws Exception{
        return orderService.PlaceOrder(orderDto);
    }
}
