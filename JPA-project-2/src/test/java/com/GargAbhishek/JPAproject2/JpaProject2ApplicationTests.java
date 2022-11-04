package com.GargAbhishek.JPAproject2;

import com.GargAbhishek.JPAproject2.entities.*;
import com.GargAbhishek.JPAproject2.repositories.EmpRepository;
import com.GargAbhishek.JPAproject2.repositories.EmployeeRepository;
import com.GargAbhishek.JPAproject2.repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpaProject2ApplicationTests {
	@Autowired
	EmployeeRepository repository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFindEmployeeWithSalaryGreaterThanAvg(){
		List<Object[]> results= repository.findEmployeeWithSalaryGreaterThanAvg();
		for (Object[] objects:
				results) {
			System.out.print(objects[0]+" ");
			System.out.println(objects[1]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateEmployeeWithSalaryLessThanAvgSalary(){
		int avgSalary= repository.averageSalary();
		repository.updateEmployeeWithSalaryLessThanAvgSalary(5000, avgSalary);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeWithMinSalary(){
		int minSalary= repository.minimumSalary();
		repository.deleteEmployeesWithMinSalary(minSalary);
	}

	@Test
	public void testFindByNameEndingWithSingh(){
		List<Object[]> results= repository.findByNameEndingWithSingh();
		for (Object[] objects:
			 results) {
			System.out.print(objects[0]+" ");
			System.out.print(objects[1]+" ");
			System.out.println(objects[2]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeHavingAgeGreaterThan(){
		repository.DeleteEmployeeHavingAgeGreaterThan(45);
	}

	@Test
	public void testCreatePaymentCreditCard(){
		CreditCard cc= new CreditCard();
		cc.setId(1001);
		cc.setAmount(2000d);
		cc.setCardNumber("123456");
		paymentRepository.save(cc);
	}

	@Test
	public void testCreatePaymentCheque(){
		Cheque cheque= new Cheque();
		cheque.setId(1002);
		cheque.setAmount(5000d);
		cheque.setChequeNumber("987654");
		paymentRepository.save(cheque);
	}

	@Test
	public void testSalaryEmbedded(){
		Emp emp= new Emp();
		emp.setId(1);
		emp.setFirstName("Abhishek");
		emp.setLastName("Garg");
		emp.setAge(22);
		Salary salary = new Salary();
		salary.setBasicSalary(5000);
		salary.setBonusSalary(1000);
		salary.setTaxAmount(2000);
		salary.setSpecialAllowanceSalary(3000);
		emp.setSalary(salary);
		empRepository.save(emp);
	}
}
