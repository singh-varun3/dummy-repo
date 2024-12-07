/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class VaccineProductCatalog {
    
    private ArrayList<VaccineProduct> vaccineProductList;

    public VaccineProductCatalog() {
        
        vaccineProductList = new ArrayList<>();
    }

    public ArrayList<VaccineProduct> getVaccineProductList() {
        return vaccineProductList;
    }

    public void setVaccineProductList(ArrayList<VaccineProduct> vaccineProductList) {
        this.vaccineProductList = vaccineProductList;
    }
    
    public VaccineProduct addNewVaccineProduct(){
        
        VaccineProduct vaccineProduct = new VaccineProduct();
        vaccineProductList.add(vaccineProduct);
        return vaccineProduct;
        
        
    }
    
    public void removeVaccineProduct(VaccineProduct vaccineProduct){
        
        vaccineProductList.remove(vaccineProduct);
    }
    
    
    
    
    
}
