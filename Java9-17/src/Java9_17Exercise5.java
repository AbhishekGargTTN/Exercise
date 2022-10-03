// Q5. Use ifPresentOrElse, or, orElseThrow Operations with Optional

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java9_17Exercise5 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        list
                .stream()
                .filter(e->e>5)
                .findFirst()
                .ifPresentOrElse(System.out::println, ()-> System.out.println("Value is not Present"));
        list
                .stream()
                .filter(e->e>50)
                .findFirst()
                .or(()-> Optional.of(-1))
                .ifPresent(System.out::println);
        list
                .stream()
                .filter(e->e>50)
                .findFirst()
                .orElseThrow();
    }
}
//--------------------------OUTPUT--------------------
//        6
//        -1
//        Exception in thread "main" java.util.NoSuchElementException: No value present
//        at java.base/java.util.Optional.orElseThrow(Optional.java:377)
//        at Java9_17Exercise5.main(Java9_17Exercise5.java:26)

