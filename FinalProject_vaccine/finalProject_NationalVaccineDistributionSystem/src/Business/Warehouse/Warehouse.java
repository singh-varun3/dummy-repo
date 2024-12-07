/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Warehouse;


import Business.Vaccine.VaccineProduct;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class Warehouse {
    
    private ArrayList<VaccineProduct> vaccineInventoryList;
    private String location;
    private int id;
    private static int count = 1;
    private double temperature;
    
    public Warehouse() {
        
        vaccineInventoryList = new ArrayList<>();
        id= count++;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    
    
    public ArrayList<VaccineProduct> getVaccineInventoryList() {
        return vaccineInventoryList;
    }

    public void setVaccineInventoryList(ArrayList<VaccineProduct> vaccineProductList) {
        this.vaccineInventoryList = vaccineProductList;
    }
    
    public VaccineProduct addNewVaccineProduct(){
        
        VaccineProduct vaccineProduct = new VaccineProduct();
        vaccineInventoryList.add(vaccineProduct);
        return vaccineProduct;
        
        
    }
    
    public void addVaccineProduct(VaccineProduct vp){
        
        vaccineInventoryList.add(vp);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void removeVaccineProduct(VaccineProduct vaccineProduct){
        
        vaccineInventoryList.remove(vaccineProduct);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
    
    
}
