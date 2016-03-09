/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import Business.Order.OrderCatalog;

/**
 *
 * @author Vaibhav
 */
public class Provider extends Person {
     
    private OrderCatalog orderHistory;
     private int id;
    private static int count = 1;

    public Provider() {
        id = count;
        count++;
    }
    
    public int getId() {
        return id;
    }

    public OrderCatalog getOrderHistory() {
        return orderHistory;
    }
    
    
        @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }
    
    
    
    
}
