// Q4. WAP to show usage of Callable and demonstrate how it is different from Runnable

import java.util.concurrent.*;

class RunnableThread implements Runnable {
    public void run() {
        System.out.println("Thread implementing Runnable");
    }
}
class CallableThread implements Callable<String>{
    public String call() throws Exception{
        return "Thread implementing Callable";
    }
}
public class MultiThreadingExercise4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableThread t1 = new CallableThread();
        Future<String> message = executorService.submit(t1);
        System.out.println(message.get().toString());

        RunnableThread t2 = new RunnableThread();
        Thread thread = new Thread(t2);
        thread.start();
        executorService.submit(t2);
        executorService.shutdown();
    }
}
//---------------------------OUTPUT-----------------------
//        Thread implementing Callable
//        Thread implementing Runnable
//        Thread implementing Runnable