import java.util.ArrayList;
public class CollectionsExercise3 {
    ArrayList<Integer> list = new ArrayList<>();
    int index = 0;
    int size = 0;
    void push(int element) {
        list.add(element);
        index++;
        size++;
    }

    public Boolean pop() {
        if (list.isEmpty()) {
            return false;
        }
        list.remove(list.size() - 1);
        index--;
        return true;

    }
    void printStack() {
        for (int i = index - 1; i >= 0; --i)
            System.out.print(list.get(i) + " ");
    }
    void getMin() {

        if(list.isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            int min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (min > list.get(i))
                    min = list.get(i);
            }
            System.out.println(min);
        }
    }
    Boolean isFull() {
        if (size == list.size())
            return true;
        else
            return false;
    }
    Boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        CollectionsExercise3 specialStack = new CollectionsExercise3();
        specialStack.push(34);
        specialStack.push(57);
        specialStack.push(98);
        specialStack.push(21);
        specialStack.push(12);
        specialStack.push(72);
        specialStack.push(83);
        specialStack.push(5);
        specialStack.push(102);
        specialStack.push(115);

        specialStack.printStack();
        System.out.println("\nIs Stack full : " + specialStack.isFull());
        System.out.println("Is Stack empty : " + specialStack.isEmpty());
        System.out.print("Minimum element is :");
        specialStack.getMin();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.pop();
        specialStack.printStack();
        System.out.println("Is Stack full : " + specialStack.isFull());
        System.out.println("Is Stack Empty : " + specialStack.isEmpty());
    }
}