//Q2) Using (instance) Method reference create and apply add and subtract method and
//        using (Static) Method reference create and apply multiplication
//        method for the functional interface created

interface MyInterface{
    void myMethod(int number1, int number2);
}
class MyClass{
    void addition(int number1,int number2){
        System.out.println("Sum of numbers is: "+(number1+number2));
    }
     void subtraction(int number1,int number2){
        System.out.println("Difference of numbers is: "+(number1-number2));
    }
    static void multiplication(int number1,int number2){
        System.out.println("Product of numbers is: "+(number1*number2));
    }
}
public class Java8Exercise2 {
    public static void main(String[] args) {
        MyInterface myinterface= (number1, number2) -> {System.out.println(number1+" "+number2);
        };

        MyClass myClass= new MyClass();
        myinterface= myClass::addition;
        myinterface.myMethod(5,10);
        myinterface= myClass::subtraction;
        myinterface.myMethod(5,10);
        myinterface= MyClass::multiplication;
        myinterface.myMethod(5,10);
    }
}
//----------------------------------OUTPUT----------------------------
//        Sum of numbers is: 15
//        Difference of numbers is: -5
//        Product of numbers is: 50