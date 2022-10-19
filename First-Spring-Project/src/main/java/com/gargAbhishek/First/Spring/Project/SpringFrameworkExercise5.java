// Q5 Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)
package com.gargAbhishek.First.Spring.Project;

import com.gargAbhishek.First.Spring.classes.Basketball;
import com.gargAbhishek.First.Spring.classes.GeneralStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gargAbhishek.First.Spring.classes")
@ComponentScan("com.gargAbhishek.First.Spring.interfaces")
public class SpringFrameworkExercise5 {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
		SpringApplication.run(SpringFrameworkExercise5.class, args);
		GeneralStore generalStore = applicationContext.getBean(GeneralStore.class);
		generalStore.getProduct();
	}

}
//--------------------------------OUTPUT------------------------
//		Getting Product
//		Haldiram
