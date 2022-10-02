// Q1. Demonstrate the use of private methods in interfaces
interface MyInterface{
    private static String reverseStrings(String string){
        return new StringBuilder(string).reverse().toString();
    }
    static void toUpperCase(String string){
        String reverseString= reverseStrings(string);
        System.out.println(reverseString.toUpperCase());
    }
    static void toLowerCase(String string){
        String reverseString= reverseStrings(string);
        System.out.println(reverseString.toLowerCase());
    }
}
public class Java9_17Exercise1 {
    public static void main(String[] args) {
        MyInterface.toLowerCase("ABHISHEK");
        MyInterface.toUpperCase("abhishek");
        }
    }
//----------------------------------OUTPUT--------------------
//        kehsihba
//        KEHSIHBA
