// Q3. Use rangeClosed to create a  Stream

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java9_17Exercise3 {
    public static void main(String[] args) {
        System.out.println(IntStream
                .rangeClosed(1,10)
                .boxed()
                .collect(Collectors.toList()));
    }
}
//---------------------------OUTPUT-------------------
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]