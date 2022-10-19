// Q3 Use @Compenent and @Autowired annotations to in Loosely Coupled code for dependency management
package com.gargAbhishek.First.Spring.Project;

import com.gargAbhishek.First.Spring.classes.Basketball;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gargAbhishek.First.Spring.classes")
@ComponentScan("com.gargAbhishek.First.Spring.interfaces")
public class SpringFrameworkExercise3 {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
		SpringApplication.run(SpringFrameworkExercise3.class, args);
		Basketball basketball = applicationContext.getBean(Basketball.class);
		basketball.playSport();
	}

}
//--------------------------------OUTPUT------------------------
//		Playing Basketball
//		in an Indoor court