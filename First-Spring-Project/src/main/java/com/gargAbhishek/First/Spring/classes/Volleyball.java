package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class Volleyball {
    @Autowired
    Sport sport;

    public Volleyball(Sport sport) {
        this.sport = sport;
    }

    public void playSport(){
        System.out.println("Playing Volleyball ");
        sport.info();
    }
}
