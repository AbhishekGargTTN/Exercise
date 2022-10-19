package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Bakery;

public class Customer {
    Bakery bakery;

    public Bakery getBakery() {
        return bakery;
    }

    public void setBakery(Bakery bakery) {
        this.bakery = bakery;
    }
    public void bakeItem(){
        bakery.bake();
    }
}
