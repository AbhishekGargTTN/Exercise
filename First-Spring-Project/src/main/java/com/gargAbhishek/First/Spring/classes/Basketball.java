package com.gargAbhishek.First.Spring.classes;

import com.gargAbhishek.First.Spring.interfaces.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Basketball {
    @Autowired
//    @Qualifier("outdoor")
    Sport sport;

    public void setSport(Sport sport) {
        this.sport = sport;
    }
   public void playSport(){
        System.out.println("Playing Basketball ");
        sport.info();
    }
}
