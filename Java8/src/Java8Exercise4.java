//Q4) WAP using java 8:
//
//        Collect all  even numbers from a list using stream
//        Given a list of objects of following class:
//
//class Employee{
//    String fullName;
//    Long salary;
//    String city;
//}
//
//    Get list of all unique firstNames of employees where their salary is less than 5000 and who live in delhi.
//        Note: Full name is concatenation of first name, middle name and last name with single space in between.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    String fullName;
    Long salary;
    String city;

    public Employee(String firstName, String middleName, String lastName, Long salary, String city) {
        this.fullName = firstName+" "+middleName+" "+lastName;
        this.salary = salary;
        this.city = city;
    }
}
public class Java8Exercise4 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .filter(e-> e % 2==0)
                .collect(Collectors.toList()));
        Employee employee1= new Employee("Abhishek", "","Garg",4000l,"Delhi");
        Employee employee2= new Employee("Nikhil", "Shankar","Kumar",3000l,"Haryana");
        Employee employee3= new Employee("Tarun", "","Singh",6000l,"Delhi");
        Employee employee4= new Employee("Joice", "V","Joseph",2000l,"Delhi");
        List<Employee> list=new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list
                .stream()
                .distinct()
                .filter((e->(e.salary<5000)&&(e.city.contains("Delhi"))))
                .map(e-> e.fullName+" "+e.salary+" "+e.city)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
//---------------------------------OUTPUT----------------------------------
//        [2, 4, 6, 8, 10]
//        Abhishek  Garg 4000 Delhi
//        Joice V Joseph 2000 Delhi