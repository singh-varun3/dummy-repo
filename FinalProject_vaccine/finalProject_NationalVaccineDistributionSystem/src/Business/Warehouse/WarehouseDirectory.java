/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Warehouse;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class WarehouseDirectory {
    
    private ArrayList<Warehouse> warehouseList;

    public WarehouseDirectory() {
        warehouseList = new ArrayList<>();
    }

    public ArrayList<Warehouse> getWarehouseList() {
        return warehouseList;
    }
    
    public Warehouse addNewWareHouse(){
        
        Warehouse warehouse = new Warehouse();
        warehouseList.add(warehouse);
        return warehouse;
    }
    
    
    public void removeWarehouse(Warehouse warehouse){
        
        warehouseList.remove(warehouse);
    }
}
