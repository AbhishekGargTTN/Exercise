// Q6 Perform Constructor Injection in a Spring Bean
package com.gargAbhishek.First.Spring.Project;

import com.gargAbhishek.First.Spring.classes.GeneralStore;
import com.gargAbhishek.First.Spring.classes.Volleyball;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gargAbhishek.First.Spring.classes")
@ComponentScan("com.gargAbhishek.First.Spring.interfaces")
public class SpringFrameworkExercise6 {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
		SpringApplication.run(SpringFrameworkExercise6.class, args);
		Volleyball volleyball = applicationContext.getBean(Volleyball.class);
		volleyball.playSport();
	}

}
//--------------------------------OUTPUT------------------------
//		Playing Volleyball
//		in an Indoor court

