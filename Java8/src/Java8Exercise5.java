//Q5)Implement multiple inheritance with default method inside interface.

interface MyInterface1{
   default void display(){
       System.out.println("This is MyInterface1 Interface");
    }
}
interface MyInterface2{
    default void display(){
        System.out.println("This is MyInterface2 Interface");
    }
}
interface MyInterface3 extends MyInterface1, MyInterface2{
    default void display(){
        MyInterface1.super.display();
        MyInterface2.super.display();
        System.out.println("This is MyInterface3 Interface");
    }
}

public class Java8Exercise5 implements MyInterface3{
    public void display(){
        MyInterface3.super.display();
        System.out.println("Default Method display in class");
    }
    public static void main(String[] args) {
        Java8Exercise5 java8Exercise5= new Java8Exercise5();
        java8Exercise5.display();
        }

}
//--------------------------------------------OUTPUT-------------------------
//        This is MyInterface1 Interface
//        This is MyInterface2 Interface
//        This is MyInterface3 Interface
//        Default Method display in class
