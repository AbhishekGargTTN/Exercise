//  Q6. Convert an Optional type into Stream

import java.util.stream.IntStream;

public class Java9_17Exercise6 {
    public static void main(String[] args) {
        IntStream
                .rangeClosed(1,10)
                .filter(e->e>7)
                .boxed()
                .findFirst()
                .stream()
                .mapMulti((number,Consumer)-> IntStream
                        .rangeClosed(1,10)
                        .forEach(e-> Consumer.accept(e*number)))
                .forEach(System.out::println);

    }
}
//---------------------------------OUTPUT------------------------
//        8
//        16
//        24
//        32
//        40
//        48
//        56
//        64
//        72
//        80