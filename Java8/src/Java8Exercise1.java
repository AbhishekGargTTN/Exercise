//Q1) Write the following a functional interface and implement it using lambda:
//
//        First number is greater than second number or not Parameter (int ,int ) Return boolean
//        Increment the number by 1 and return incremented value Parameter (int) Return int
//        Concatination of 2 string Parameter (String , String ) Return (String)
//        Convert a string to uppercase and return . Parameter (String) Return (String)

interface FindGreater{
    boolean isGreater(int number1,int number2);
}
interface IncrementNumber{
    int increment(int number);
}
interface ConcatStrings{
    String concatenation(String string1, String string2);
}
interface UpperCaseStrings{
    String upperCase(String string);
}
public class Java8Exercise1 {
    public static void main(String[] args) {
        FindGreater greater= (int number1, int number2) -> {if(number1>number2) return true; else return false;};
        System.out.println(greater.isGreater(5,2));
        IncrementNumber increment= (int number) -> (number+1);
        System.out.println(increment.increment(5));
        ConcatStrings concat= (String string1, String string2)-> (string1.concat(string2));
        System.out.println(concat.concatenation("Abhishek","Garg"));
        UpperCaseStrings upperCase=(String string)->(string.toUpperCase());
        System.out.println(upperCase.upperCase("abhishek"));
    }
}

//---------------------------------OUTPUT----------------------------
//        true
//        6
//        AbhishekGarg
//        ABHISHEK