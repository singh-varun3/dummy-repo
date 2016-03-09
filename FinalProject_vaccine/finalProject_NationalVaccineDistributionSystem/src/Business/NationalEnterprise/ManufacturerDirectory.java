/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.NationalEnterprise;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class ManufacturerDirectory {
    
    private ArrayList<Manufacturer> manufacturerList;

    public ManufacturerDirectory() {
        
        manufacturerList = new ArrayList<>();
        
    }

    public ArrayList<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    public void setManufacturerList(ArrayList<Manufacturer> manufacturerList) {
        this.manufacturerList = manufacturerList;
    }
    
    public Manufacturer addNewManufacturer(String name){
        
        Manufacturer newManufacturer = new Manufacturer(name);
        manufacturerList.add(newManufacturer);
        return newManufacturer;
        
        
    }
    
    public void removeManufacturer(Manufacturer manufacturer){
        
        manufacturerList.remove(manufacturer);
    }
    
    
}
