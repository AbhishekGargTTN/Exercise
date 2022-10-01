
//Q3)Create a thread using lambda function

public class Java8Exercise3 {
    public static void main(String[] args) {
        Runnable newThread= ()->{
            Thread.currentThread().setName("Abhishek's Thread");
            System.out.println(Thread.currentThread().getName());
        };
        Thread thread=new Thread(newThread);
        thread.start();
    }
}
//--------------------------------------OUTPUT---------------------------------
//        Abhishek's Thread