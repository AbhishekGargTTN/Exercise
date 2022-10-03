// Q 12. Demonstrate the use of Sealed Classes.

sealed class Base permits Child1,Child2{
    void display(){
        System.out.println("This is Base Class");
    }
}
final class Child1 extends Base{
    void display(){
        System.out.println("This is Child1 Class");
    }
}
non-sealed class Child2 extends Base{
    void display(){
        System.out.println("This is Child2 Class");
    }
}
public class Java9_17Exercise12{
    public static void main(String[] args) {
        Base base= new Base();
        base.display();
        Base child1=new Child1();
        child1.display();
        Base child2=new Child2();
        child2.display();
    }
}
//-----------------------------------OUTPUT-------------------------------
//        This is Base Class
//        This is Child1 Class
//        This is Child2 Class