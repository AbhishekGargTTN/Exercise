// Q 1. Create and Run a Thread using Runnable Interface and Thread class
// and show usage of sleep and join methods in the created threads.
class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread made using Runnable Interface");
    }
}
class ThreadThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread made using Thread Class");
    }
}
public class MultiThreadingExercise1 {
    public static void main(String[] args) {
        ThreadRunnable threadRunnable= new ThreadRunnable();
        ThreadThread threadThread= new ThreadThread();
        threadThread.start();
        try {
            threadThread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            threadThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(threadRunnable).start();
    }
}
//-----------------------------------OUTPUT-----------------------
//        Thread made using Runnable Interface
//        Thread made using Thread Class