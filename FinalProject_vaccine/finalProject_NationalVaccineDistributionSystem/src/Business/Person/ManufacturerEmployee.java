/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import Business.Vaccine.VaccineProductCatalog;

/**
 *
 * @author Vaibhav
 */
public class ManufacturerEmployee extends Person{
    
    private int id;
    private static int count = 1;
    //private VaccineProductCatalog vaccineProductCatalog;

    public ManufacturerEmployee() {
        id = count;
        count++;
        this.setLastName(null);
       // this.vaccineProductCatalog = new VaccineProductCatalog();
        
    }
    
     public int getId() {
        return id;
    }
     
        @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
    
}
