// Q7. Use Of method to create List, Set and Map

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9_17Exercise7 {
    public static void main(String[] args) {
        System.out.println(List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(Set.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(Map.of(1,"Cat",2,"Dog",3,"Snake"));
    }
}
//---------------------------OUTPUT---------------------
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//        [1, 10, 9, 8, 7, 6, 5, 4, 3, 2]
//        {3=Snake, 2=Dog, 1=Cat}