class Person{
    static  String firstName="Abhishek";;
    static String lastName="Garg";
    static int age=22;
    static void printInfo()
    {
        System.out.println("My name is "+firstName+" "+lastName+" and I am "+age+" years old");
    }
    static
    {
        System.out.println("My name is "+firstName+" "+lastName+" and I am "+age+" years old");
    }
}
public class Exercise1 {
    public static void main(String[] args) {

        System.out.println("My name is "+Person.firstName+" "+Person.lastName+" and I am "+Person.age+" years old");
        Person person1=new Person();
        person1.printInfo();
    }
}
