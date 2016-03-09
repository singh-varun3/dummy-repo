/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

import Business.Vaccine.AdministeredVaccine;
import Business.Vaccine.VaccineProduct;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class Clinic {

    private String clinicName;
    private boolean registered;
    private ArrayList<VaccineProduct> vaccineInventoryClinic;
    private ArrayList<AdministeredVaccine> administeredVaccineList;
    private double temperature;

    public Clinic() {
        registered = false;
        vaccineInventoryClinic = new ArrayList<>();
        administeredVaccineList = new ArrayList<>();

    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    
    
    public ArrayList<VaccineProduct> getVaccineInventoryClinic() {
        return vaccineInventoryClinic;
    }

    public ArrayList<AdministeredVaccine> getAdministeredVaccineList() {
        return administeredVaccineList;
    }

    public void setAdministeredVaccineList(ArrayList<AdministeredVaccine> administeredVaccineList) {
        this.administeredVaccineList = administeredVaccineList;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public VaccineProduct addVaccine(VaccineProduct vaccine) {
        vaccineInventoryClinic.add(vaccine);
        return vaccine;

    }

    public VaccineProduct addNewVaccine() {
        VaccineProduct product = new VaccineProduct();
        vaccineInventoryClinic.add(product);
        return product;

    }

    public void removeVaccine(VaccineProduct vaccine) {

        vaccineInventoryClinic.remove(vaccine);

    }

    public AdministeredVaccine addNewAdministeredVaccine() {
        AdministeredVaccine vaccine = new AdministeredVaccine();
        administeredVaccineList.add(vaccine);
        return vaccine;

    }

    public int getTotalVaccinesAdministered() {
        int total = 0;
        if (administeredVaccineList != null) {
            for (AdministeredVaccine vaccine : administeredVaccineList) {
                total = total + 1;
            }

        }

        return total;

    }

    public int getTotalFailedVaccines() {
        int total = 0;
        if (administeredVaccineList != null) {
            for (AdministeredVaccine vaccine : administeredVaccineList) {
                if (vaccine != null) {
                    if (vaccine.getInjectionStatus() != null) {
                        if (vaccine.getInjectionStatus().equalsIgnoreCase("Fail")) {
                            total = total + 1;
                        }
                    }
                }
            }

        }

        return total;

    }
    
    public int getTotalVaccinesStored() {
        int total = 0;
        if (vaccineInventoryClinic != null) {
            for (VaccineProduct vaccine : vaccineInventoryClinic) {
                total = total + vaccine.getAvailablity();
            }
            total = total + getTotalVaccinesAdministered();
        }

        return total;

    }

    @Override
    public String toString() {
        return clinicName;
    }

}
