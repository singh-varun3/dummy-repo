/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import java.util.Date;

/**
 *
 * @author Vaibhav
 */
public class VaccineProduct {
    
    private Vaccine vaccineDefinition;
    private int vaccineId;
    private static int count = 1;
    private Date manufactureDate;
    private Date dateOfExpiry;
    private String batchId;
    private double vaccinePrice;
    private double minOperatingTemp;
    private double maxOperatingTemp;
    private int availablity;
    private String manufacturerName;

    public VaccineProduct() {
        vaccineId = count;
        count++;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
    
    
    
    public int getAvailablity() {
        return availablity;
    }

    public void setAvailablity(int availablity) {
        this.availablity = availablity;
    }

    public double getMinOperatingTemp() {
        return minOperatingTemp;
    }

    public void setMinOperatingTemp(double minOperatingTemp) {
        this.minOperatingTemp = minOperatingTemp;
    }

    public double getMaxOperatingTemp() {
        return maxOperatingTemp;
    }

    public void setMaxOperatingTemp(double maxOperatingTemp) {
        this.maxOperatingTemp = maxOperatingTemp;
    }
    
    

    public Vaccine getVaccineDefinition() {
        return vaccineDefinition;
    }

    public void setVaccineDefinition(Vaccine vaccineDefinition) {
        this.vaccineDefinition = vaccineDefinition;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public double getVaccinePrice() {
        return vaccinePrice;
    }

    public void setVaccinePrice(double vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }

    @Override
    public String toString() {
        return vaccineDefinition.getVaccineCode();
    }
    
    
    
    
}
