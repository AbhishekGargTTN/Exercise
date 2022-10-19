package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Sport;
import com.gargAbhishek.First.Spring.interfaces.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralStore {
    @Autowired
    Warehouse warehouse;

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public void getProduct(){
        System.out.println("Getting Product");
        warehouse.brand();
    }
}
