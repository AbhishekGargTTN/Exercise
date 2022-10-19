package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Sport;
import com.gargAbhishek.First.Spring.interfaces.Warehouse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FoodItem implements Warehouse {

    @Override
    public void brand() {
        System.out.println("Haldiram");
    }
}
