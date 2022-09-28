import java.util.*;
class Employees {
    String name;
    int age;
    String designation;
    int salary;
    Employees(String name,int age,String designation,int salary) {
        this.name=name;
        this.age=age;
        this.designation=designation;
        this.salary=salary;
    }
}
public class CollectionsExercise4 {
    public static void main(String[] args) {
        Employees employee1 = new Employees("Abhishek Garg", 22, "JVM", 50000);
        Employees employee2 = new Employees("Tarun Singh", 22, "JVM", 55000);
        Employees employee3 = new Employees("Nikhil Sharma", 23, "QE", 65000);
        Map<Employees, Integer> map1 = new HashMap<>();
        map1.put(employee1, employee1.salary);
        map1.put(employee2, employee2.salary);
        map1.put(employee3, employee3.salary);
        for (Map.Entry<Employees, Integer> map2 : map1.entrySet()) {
            Employees employee = map2.getKey();
            System.out.println(map2.getKey() + " " + employee.age + " " + employee.name + " " + employee.designation + " : " + map2.getValue());
        }
    }
}
