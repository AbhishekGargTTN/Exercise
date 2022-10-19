package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Bakery;

public class Cookies implements Bakery {
    @Override
    public void bake() {
        System.out.println("Baking Cookies");
    }
}
