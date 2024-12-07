/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.Order.Order;
import java.util.Date;

/**
 *
 * @author Vaibhav
 */
public class VaccineOrderWorkRequest extends WorkRequest {
    
    private Order vaccineOrder;
    private Date shipdate;

    public VaccineOrderWorkRequest() {
        vaccineOrder = new Order();
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }
    
    

    public Order getVaccineOrder() {
        return vaccineOrder;
    }

    public void setVaccineOrder(Order vaccineOrder) {
        this.vaccineOrder = vaccineOrder;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccineOrder.getOrderNumber());
    }
    
    
    
    
}
