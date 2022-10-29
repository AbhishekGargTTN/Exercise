package com.GargAbhishek.Jpaproject;

import com.GargAbhishek.Jpaproject.entities.EmployeeEntity;
import com.GargAbhishek.Jpaproject.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class JpaProjectApplicationTests {

	@Autowired
	EmployeeRepository repository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateEmployee(){
		EmployeeEntity employee= new EmployeeEntity();
		employee.setId(1);
		employee.setName("Abhishek Garg");
		employee.setAge(22);
		employee.setLocation("Delhi");
		repository.save(employee);
	}

	@Test
	public void testUpdateEmployee(){
		EmployeeEntity employee= new EmployeeEntity();
		employee.setId(1);
		employee.setName("Abhishek Garg");
		employee.setAge(23);
		employee.setLocation("Delhi");
		repository.save(employee);
	}

	@Test
	public void testDeleteEmployee(){
		if(repository.existsById(1)) {
			repository.deleteById(1);
		}
	}

	@Test
	public void testFindAllEmployee(){
		repository.findAll().forEach(e-> System.out.println(e.toString()));
	}

	@Test
	public void testCountAllEmployee(){
		System.out.println("Total Number of Records: "+repository.count());
	}

	@Test
	public void testPagingAndSorting(){
		Sort sort= Sort.by("age");
		PageRequest pageable= PageRequest.of(1,2,sort);
		System.out.println("Page 2");
		Iterable<EmployeeEntity> results = repository.findAll(pageable);
		results.forEach(e-> System.out.println(e.getName()+" "+e.getAge()));
	}

	@Test
	public void testFindEmployeeByName(){
		List<EmployeeEntity> employee = repository.findByName("Abhishek Garg");
		employee.forEach(e-> System.out.println(e.toString()));
	}

	@Test
	public void testFindEmployeeByNameLike(){
		List<EmployeeEntity> employee = repository.findByNameLike("A%");
		employee.forEach(e-> System.out.println(e.toString()));
	}

	@Test
	public void testFindEmployeeByAgeBetween(){
		List<EmployeeEntity> employee = repository.findByAgeBetween(28,32);
		employee.forEach(e-> System.out.println(e.toString()));
	}
}
