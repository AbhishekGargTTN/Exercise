// Q4  Get a Spring Bean from application context and display its properties.
package com.gargAbhishek.First.Spring.Project;

import com.gargAbhishek.First.Spring.classes.Basketball;
import com.gargAbhishek.First.Spring.classes.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gargAbhishek.First.Spring.classes")
@ComponentScan("com.gargAbhishek.First.Spring.interfaces")
public class SpringFrameworkExercise4 {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
		SpringApplication.run(SpringFrameworkExercise4.class, args);
		Employee employee = applicationContext.getBean(Employee.class);
		System.out.println(employee.toString());
	}

}
//--------------------------------OUTPUT------------------------
//		Name: Abhishek Garg
//		ID: 6573
//		Competency: JVM