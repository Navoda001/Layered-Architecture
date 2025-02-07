/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.service.custom.impl;

import edu.ijse.layerd.dao.DaoFactory;
import edu.ijse.layerd.dao.custom.ItemDao;
import edu.ijse.layerd.dto.ItemDto;
import edu.ijse.layerd.entity.ItemEntity;
import edu.ijse.layerd.service.custom.ItemService;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String save(ItemDto itemDto) throws Exception {
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemCode(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrize(),
                itemDto.getQoh());
        boolean isSaved = itemDao.save(itemEntity);
        return isSaved ? "Success" : "Fail";
    }

    @Override
    public String update(ItemDto itemDto) throws Exception {
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemCode(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrize(),
                itemDto.getQoh());
        boolean isUpdated = itemDao.update(itemEntity);
        return isUpdated ? "Success" : "Fail";
    }

    @Override
    public String delete(String code) throws Exception {
        boolean isDelted = itemDao.delete(code);
        return isDelted ? "Success" : "Fail";
    }

    @Override
    public ItemDto search(String code) throws Exception {
        ItemEntity itemEntity = itemDao.search(code);
        if(itemEntity != null){
            return new ItemDto(itemEntity.getItemCode(),
            itemEntity.getDescription(),
            itemEntity.getPackSize(),
            itemEntity.getUnitPrice(),
            itemEntity.getQoh());
        }
        return null;
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntities = itemDao.getAll();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        
        for (ItemEntity itemEntity : itemEntities) {
            ItemDto dto = new ItemDto(itemEntity.getItemCode(),
            itemEntity.getDescription(),
            itemEntity.getPackSize(),
            itemEntity.getUnitPrice(),
            itemEntity.getQoh());
            itemDtos.add(dto);
        }
        return itemDtos;
    }

}
