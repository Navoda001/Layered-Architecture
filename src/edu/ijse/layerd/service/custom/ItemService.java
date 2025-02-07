/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.layerd.service.custom;

import edu.ijse.layerd.dto.ItemDto;
import edu.ijse.layerd.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public interface ItemService extends SuperService {
    public String save(ItemDto itemDto)throws Exception;
    
    public String update(ItemDto itemDto)throws Exception;
    
    public String delete(String code)throws Exception;
    
    public ItemDto search(String code)throws Exception;
    
    public ArrayList<ItemDto> getAll()throws Exception;
}
