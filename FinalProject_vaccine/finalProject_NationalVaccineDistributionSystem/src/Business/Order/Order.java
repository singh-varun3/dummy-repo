/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import Business.Vaccine.VaccineProduct;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class Order {
    
    private ArrayList<OrderItem> orderList;
    private static int counter = 0;
    private int orderNumber;

    public Order() {
        counter++;
        orderNumber = counter;
        orderList = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }
           
   
    
    public ArrayList<OrderItem> getOrderList() {
        return orderList;
    }
    
    
    public OrderItem addNewOrderItem(int quantity, VaccineProduct vaccineProduct){
        
        OrderItem orderItem = new OrderItem();
        orderItem.setVaccineProduct(vaccineProduct);
        orderItem.setQuantity(quantity);
        orderList.add(orderItem);
        
        return orderItem;
    }
    
    public void removeOrderItem(OrderItem oi){
        
        orderList.remove(oi);
    }
    
}
