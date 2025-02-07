/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.service;

import edu.ijse.layerd.service.custom.impl.CustomerServiceImpl;
import edu.ijse.layerd.service.custom.impl.ItemServiceImpl;
import edu.ijse.layerd.service.custom.impl.OrderServiceImpl;


/**
 *
 * @author Navoda Chathurya
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case ITEM:
                return new ItemServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl() ;
            default:
                return null;
        }
    }



    public enum ServiceType {
        ITEM, ORDER, CUSTOMER
    }
}
