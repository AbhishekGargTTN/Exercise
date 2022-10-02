// Q4. Use iterator stream method to generate a stream

import java.util.stream.IntStream;

public class Java9_17Exercise4 {
    public static void main(String[] args) {
        IntStream
                .iterate(0, i->i<=10, i->i+1)
                .boxed()
                .forEach(System.out::println);
    }
}
//-------------------------------OUTPUT-------------------------------
//        0
//        1
//        2
//        3
//        4
//        5
//        6
//        7
//        8
//        9
//        10