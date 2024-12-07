/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.Network.StateNetwork;
import Business.Order.Order;
import Business.Organization.SatelliteClinicOrganization;
import Business.UserAccount.UserAccount;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Vaibhav
 */
public class ProviderVaccineOrderWorkRequest extends WorkRequest{
    
    private Order vaccineOrder;
    private Date deliveryDate;
    private boolean bimonthlyContract;
    private boolean monthlyContract;
    private boolean adhocRequest;
    private boolean approvedByPHD;
    private boolean approvedByCDC;
    private Enterprise enterprise;
    private UserAccount phdApprovedBy;
    private UserAccount cdcApprovedBy;
    private StateNetwork requestState;
    private boolean satelliteClinicOrder;
    private SatelliteClinicOrganization satelliteClinicOrg;
    
    public ProviderVaccineOrderWorkRequest() {
        vaccineOrder = new Order();
        this.setRequestDate(new Date());
        satelliteClinicOrder= false;
    }

    public boolean isSatelliteClinicOrder() {
        return satelliteClinicOrder;
    }

    public void setSatelliteClinicOrder(boolean satelliteClinicOrder) {
        this.satelliteClinicOrder = satelliteClinicOrder;
    }

    public SatelliteClinicOrganization getSatelliteClinicOrg() {
        return satelliteClinicOrg;
    }

    public void setSatelliteClinicOrg(SatelliteClinicOrganization satelliteClinicOrg) {
        this.satelliteClinicOrg = satelliteClinicOrg;
    }
    
    
    
    public StateNetwork getRequestState() {
        return requestState;
    }

    public void setRequestState(StateNetwork requestState) {
        this.requestState = requestState;
    }
    
    

    public UserAccount getPhdApprovedBy() {
        return phdApprovedBy;
    }

    public void setPhdApprovedBy(UserAccount phdApprovedBy) {
        this.phdApprovedBy = phdApprovedBy;
    }

    public UserAccount getCdcApprovedBy() {
        return cdcApprovedBy;
    }

    public void setCdcApprovedBy(UserAccount cdcApprovedBy) {
        this.cdcApprovedBy = cdcApprovedBy;
    }
    
    public void calculateDeliveryDate(ProviderVaccineOrderWorkRequest request){
        
        if(request.adhocRequest)
        {
            return;
        }
        
        Date requestDate = request.getRequestDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(requestDate);      
       
        if(request.bimonthlyContract)
            cal.add(Calendar.DATE, 15);
        if(request.monthlyContract)
            cal.add(Calendar.DATE, 30);
        
        requestDate = cal.getTime();
        
        request.setDeliveryDate(requestDate);
        
        
        
        
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Order getVaccineOrder() {
        return vaccineOrder;
    }

    public void setVaccineOrder(Order vaccineOrder) {
        this.vaccineOrder = vaccineOrder;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isBimonthlyContract() {
        return bimonthlyContract;
    }

    public void setBimonthlyContract(boolean bimonthlyContract) {
        this.bimonthlyContract = bimonthlyContract;
    }

    public boolean isMonthlyContract() {
        return monthlyContract;
    }

    public void setMonthlyContract(boolean monthlyContract) {
        this.monthlyContract = monthlyContract;
    }

    public boolean isAdhocRequest() {
        return adhocRequest;
    }

    public void setAdhocRequest(boolean adhocRequest) {
        this.adhocRequest = adhocRequest;
    }

    public boolean isApprovedByPHD() {
        return approvedByPHD;
    }

    public void setApprovedByPHD(boolean approvedByPHD) {
        this.approvedByPHD = approvedByPHD;
    }

    public boolean isApprovedByCDC() {
        return approvedByCDC;
    }

    public void setApprovedByCDC(boolean approvedByCDC) {
        this.approvedByCDC = approvedByCDC;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccineOrder.getOrderNumber());
    }
    
    
   
    
    
    
    
    
}
