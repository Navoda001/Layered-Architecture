/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.service.custom.impl;

import edu.ijse.layerd.dao.DaoFactory;
import static edu.ijse.layerd.dao.DaoFactory.DaoTypes.ORDER_DETAILS;
import edu.ijse.layerd.dao.custom.ItemDao;
import edu.ijse.layerd.dao.custom.OrderDao;
import edu.ijse.layerd.dao.custom.OrderDetailDao;
import edu.ijse.layerd.db.DBConnection;
import edu.ijse.layerd.dto.OrderDetailDto;
import edu.ijse.layerd.dto.OrderDto;
import edu.ijse.layerd.entity.ItemEntity;
import edu.ijse.layerd.entity.OrderDetailEntity;
import edu.ijse.layerd.entity.OrderEntity;
import edu.ijse.layerd.service.custom.OrderService;
import java.sql.Connection;

/**
 *
 * @author Navoda Chathurya
 */
public class OrderServiceImpl implements OrderService {

    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAILS);

    @Override
    public String PlaceOrder(OrderDto orderDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            OrderEntity orderEntity = new OrderEntity(orderDto.getOrderId(), orderDto.getCustId(), orderDto.getDate());
            if (orderDao.save(orderEntity)) {
                boolean isOrderDetailSaved = true;
                for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity(orderDto.getOrderId(), orderDetailDto.getItemCode(), orderDetailDto.getDiscount(), orderDetailDto.getQty());
                    if (!orderDetailDao.save(orderDetailEntity)) {
                        isOrderDetailSaved = false;
                    }
                }
                if (isOrderDetailSaved) {
                    boolean isItemUpdated = true;

                    for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.search(orderDetailDto.getItemCode());
                        if (itemEntity != null) {
                            itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
                            if (!itemDao.update(itemEntity)) {
                                isItemUpdated = false;
                            }

                        } else {
                            connection.rollback();
                            return "Item Not Found";
                        }
                    }
                    if(isItemUpdated){
                        connection.commit();
                        return "Success";
                    }else{
                         connection.rollback();
                    return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else {
                connection.rollback();
                return "Order Save Error";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
