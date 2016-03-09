/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class OrderCatalog {
    
    private ArrayList<Order> orderList;

    public OrderCatalog() {
        orderList = new ArrayList<>();
        
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    
    public Order addNewOrder(){
        Order order = new Order();
        orderList.add(order);
        return order;
    }
    
    public Order addOrder(Order order){
        
       
        orderList.add(order);
        return order;
    }
    
    
    public void removeOrder(Order order){
        orderList.remove(order);
        
    }
    
}
