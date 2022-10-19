// Q2 Write a program to demonstrate Loosely Coupled code.
package com.gargAbhishek.First.Spring.Project;

import com.gargAbhishek.First.Spring.classes.Cake;
import com.gargAbhishek.First.Spring.classes.Cookies;
import com.gargAbhishek.First.Spring.classes.Customer;

public class SpringFrameworkExercise2 {
    public static void main(String[] args) {
        Customer customer= new Customer();
        customer.setBakery(new Cake());
        customer.bakeItem();
        customer.setBakery(new Cookies());
        customer.bakeItem();
    }
}
//------------------------------OUTPUT----------------------
//        Baking Cake
//        Baking Cookies


