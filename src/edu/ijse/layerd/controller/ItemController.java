/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.controller;

import edu.ijse.layerd.dto.ItemDto;
import edu.ijse.layerd.service.ServiceFactory;
import edu.ijse.layerd.service.custom.ItemService;

import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public class ItemController {
    
    private  ItemService itemService =(ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
    
    public String save(ItemDto dto)throws Exception{
        return itemService.save(dto);
    }
    public String update(ItemDto dto)throws Exception{
        return itemService.update(dto);
    }
    public String delete(String itemCode)throws Exception{
        return itemService.delete(itemCode);
    }
    public ItemDto search(String itemCode)throws Exception{
        return itemService.search(itemCode);
    }
    public ArrayList<ItemDto> getAll()throws Exception{
        return itemService.getAll();
    }
}
 