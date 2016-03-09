/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.Order.Order;

/**
 *
 * @author Vaibhav
 */
public class PaymentRequestWorkRequest extends WorkRequest {
    
    private ProviderVaccineOrderWorkRequest providerRequest;
    private Order vaccineOrder;
    private Order billedOrder;
    private double amount;

    public PaymentRequestWorkRequest() {
        
        billedOrder = new Order();
    }

    public ProviderVaccineOrderWorkRequest getProviderRequest() {
        return providerRequest;
    }

    public void setProviderRequest(ProviderVaccineOrderWorkRequest providerRequest) {
        this.providerRequest = providerRequest;
    }
   
   

    
    
    

    public Order getVaccineOrder() {
        return vaccineOrder;
    }

    public void setVaccineOrder(Order vaccineOrder) {
        this.vaccineOrder = vaccineOrder;
    }

    public Order getBilledOrder() {
        return billedOrder;
    }

    public void setBilledOrder(Order billedOrder) {
        this.billedOrder = billedOrder;
    }

    

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccineOrder.getOrderNumber());
    }
    
    
    
}
