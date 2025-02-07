/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.dao.custom.impl;

import com.mysql.cj.protocol.Resultset;
import edu.ijse.layerd.dao.CrudUtil;
import edu.ijse.layerd.dao.custom.ItemDao;
import edu.ijse.layerd.entity.ItemEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public class ItemDaoImpl implements ItemDao{

    @Override
    public boolean save(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES (?,?,?,?,?)",
                t.getItemCode(), t.getDescription(), t.getPackSize(), t.getUnitPrice(), t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET Description = ?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?",
                t.getDescription(), t.getPackSize(), t.getUnitPrice(), t.getQoh(), t.getItemCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
     return CrudUtil.executeUpdate("DELETE from item WHERE ItemCode=?", id);
    }

    @Override
     public ItemEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.extecuteQuery("SELECT * from item WHERE ItemCode=?", id);
        if(rst.next()){
            return new ItemEntity(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand"));
        }
        return null;
    }
     
    @Override
     public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.extecuteQuery("SELECT * from item");
        while(rst.next()){
            itemEntities.add(new ItemEntity(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")));
        }
        return itemEntities;
    }
    
}
