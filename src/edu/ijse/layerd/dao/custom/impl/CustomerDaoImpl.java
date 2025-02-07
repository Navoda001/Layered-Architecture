/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.CrudUtil;
import edu.ijse.layerd.dao.custom.CustomerDao;
import edu.ijse.layerd.entity.CustomerEntity;
import edu.ijse.layerd.entity.CustomerEntity;
import edu.ijse.layerd.entity.ItemEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Navoda Chathurya
 */
public class CustomerDaoImpl implements CustomerDao{

    @Override
    public boolean save(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES (?,?,?,?,?)",
                t.getId(), t.getTitle(), t.getName(), t.getDob(), t.getSalary(), t.getAddress(),t.getCity(),t.getProvince(),t.getPostalCode());
    }

    @Override
   public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET Description = ?, PackSize=?, UnitPrice=?, QtyOnHand=? WHERE ItemCode=?",
                t.getTitle(), t.getName(), t.getDob(), t.getSalary(), t.getAddress(),t.getCity(),t.getProvince(),t.getPostalCode(), t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
     return CrudUtil.executeUpdate("DELETE from item WHERE ItemCode=?", id);
    }

    @Override
     public CustomerEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.extecuteQuery("SELECT * FROM Customer WHERE CustID = ?", id);
        if(rst.next()){
            return new CustomerEntity(rst.getString("CustID"), rst.getString("CustTitle"),
                    rst.getString("CustName"), rst.getString("DOB"),
                    rst.getDouble("salary"), rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"), rst.getString("PostalCode"));
        }
        return null;
    }

    @Override
     public ArrayList<CustomerEntity> getAll() throws Exception {
        ArrayList<CustomerEntity> customerEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.extecuteQuery("SELECT * FROM Customer");
        while (rst.next()) {            
            customerEntities.add(new CustomerEntity(rst.getString("CustID"), rst.getString("CustTitle"),
                    rst.getString("CustName"), rst.getString("DOB"),
                    rst.getDouble("salary"), rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"), rst.getString("PostalCode")));
        }
        return customerEntities;
    }
    
}
