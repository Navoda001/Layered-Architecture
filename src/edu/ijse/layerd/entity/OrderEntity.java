/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.entity;

/**
 *
 * @author Navoda Chathurya
 */
public class OrderEntity {
    
    private String id;
    private String custId;
    private String date;

    public OrderEntity() {
    }

    public OrderEntity(String id, String custId, String date) {
        this.id = id;
        this.custId = custId;
        this.date = date;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", custId=" + custId + ", date=" + date + '}';
    }
    
    
    
    
}
