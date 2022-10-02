// Q9. Create Unmodifiable List from a Steam

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java9_17Exercise9 {
    public static void main(String[] args) {

        List<Integer> list= new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
                list.stream()
                .filter(e->e%2==0).collect(Collectors.toUnmodifiableList()).add(10);

    }
}
//-----------------------------OUTPUT-----------------------
//        Exception in thread "main" java.lang.UnsupportedOperationException
//        at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
//        at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:147)
//        at Java9_17Exercise9.main(Java9_17Exercise9.java:21)