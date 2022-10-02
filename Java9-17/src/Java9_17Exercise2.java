//   Q2. Perform takeWhile and dropWhile operations on stream


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java9_17Exercise2 {
    public static void main(String[] args) {
        System.out.println(IntStream
                .rangeClosed(1,10)
                .takeWhile(e->e<=5)
                .boxed()
                .collect(Collectors.toList()));
        System.out.println(IntStream
                .rangeClosed(1,10)
                .dropWhile(e->e<=5)
                .boxed()
                .collect(Collectors.toList()));
    }
}
//----------------------------------OUTPUT--------------------
//        [1, 2, 3, 4, 5]
//        [6, 7, 8, 9, 10]
