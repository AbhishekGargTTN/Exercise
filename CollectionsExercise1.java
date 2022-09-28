import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsExercise1 {
    public static void main(String[] args) {
        List<Float> list=new ArrayList<Float>();
        list.add(3.4f);
        list.add(35.8f);
        list.add(8.6f);
        list.add(11.7f);
        list.add(12.2f);
        float sum=0;
        Iterator<Float> it= list.iterator();
        while(it.hasNext()){
            float temp=it.next();
            sum+=temp;
        }
        System.out.println("Sum of elements is: "+sum);
    }
}
