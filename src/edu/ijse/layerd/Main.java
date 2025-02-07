/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.ijse.layerd;

import edu.ijse.layerd.db.DBConnection;
import edu.ijse.layerd.view.CustomerForm;
import edu.ijse.layerd.view.ItemView;
import edu.ijse.layerd.view.OrderView;
import java.sql.SQLException;

/**
 *
 * @author Navoda Chathurya
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
       new OrderView().setVisible(true);
    }
    
}
 