package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Sport;
import com.gargAbhishek.First.Spring.interfaces.Warehouse;
import org.springframework.stereotype.Component;

@Component

public class SkinCareItem implements Warehouse {

    @Override
    public void brand() {
        System.out.println("Plum");
    }
}
