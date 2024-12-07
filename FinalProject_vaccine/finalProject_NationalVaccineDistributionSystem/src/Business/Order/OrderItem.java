/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import Business.Vaccine.VaccineProduct;

/**
 *
 * @author Vaibhav
 */
public class OrderItem {
    
    private VaccineProduct vaccineProduct;
    private int quantity;

    public VaccineProduct getVaccineProduct() {
        return vaccineProduct;
    }

    public void setVaccineProduct(VaccineProduct vaccineProduct) {
        this.vaccineProduct = vaccineProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return vaccineProduct.getVaccineDefinition().getVaccineName();
    }
    
    
    
}
