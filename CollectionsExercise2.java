import java.util.*;
class NameComparator implements Comparator<Employee> {
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }
}
class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee emp1, Employee emp2) {
        double salary1= emp1.salary;
        double salary2= emp2.salary;
        if(salary1>salary2){
            return 1;
        }
        else if (salary1<salary2){
            return -1;
        }
        return 0;
    }

}
class Employee {
    String name;
    double age;
    double salary;
    public Employee(String name, double age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee Name: "+ name + ", age=" + age + ", salary=" + salary;
    }
}
public class CollectionsExercise2 {
    public static void main(String[] args) {
        Employee emp1= new Employee("Abhishek Garg",22,50000);
        Employee emp2= new Employee("Tarun Singh",22,65000);
        Employee emp3= new Employee("Nikil Sharma",22,45000);
        List<Employee> employeeList= new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        System.out.println("Data before sorting");
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
        System.out.println("Sorting based on Name");
        Collections.sort(employeeList, new NameComparator());
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
        System.out.println("Sorting based on Salary");
        Collections.sort(employeeList, new SalaryComparator());
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}
