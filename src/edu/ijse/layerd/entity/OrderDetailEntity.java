/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layerd.entity;

/**
 *
 * @author Navoda Chathurya
 */
public class OrderDetailEntity {
    private String orderid;
    private String itemCode;
    private double Discount;
    private int qty;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String orderid, String itemCode, double Discount, int qty) {
        this.orderid = orderid;
        this.itemCode = itemCode;
        this.Discount = Discount;
        this.qty = qty;
    }

    /**
     * @return the orderid
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the Discount
     */
    public double getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" + "orderid=" + orderid + ", itemCode=" + itemCode + ", Discount=" + Discount + ", qty=" + qty + '}';
    }

   
}
