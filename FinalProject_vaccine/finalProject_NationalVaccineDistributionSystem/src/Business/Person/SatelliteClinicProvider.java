/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import Business.Enterprise.HospitalEnterprise;

/**
 *
 * @author Vaibhav
 */
public class SatelliteClinicProvider extends Person{
    
     private int id;
    private static int count = 1;
    //private HospitalEnterprise affliatedHospital;

    public SatelliteClinicProvider() {
        id = count;
        count++;
        //affliatedHospital = enterprise;
    }
    
    
    
    public int getId() {
        return id;
    }
    
        @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }
    
}
