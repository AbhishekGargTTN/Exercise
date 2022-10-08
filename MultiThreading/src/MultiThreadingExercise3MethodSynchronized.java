// Q 3. Use Synchronize method and synchronize block to enable synchronization
//         between multiple threads trying to access method at same time.


class TicketBookingCounter2 {
    int ticketsAvailable = 2;
    synchronized void bookTicket(String name, int ticketsToBook) {
        if((ticketsAvailable >= ticketsToBook) && (ticketsToBook > 0)) {
            System.out.println(name+" : "+ ticketsToBook + " Tickets Booked Successfully");
            ticketsAvailable -= ticketsToBook;
        } else {
            System.out.println(name +" : No Tickets are Available");
        }
    }
}
class TicketCounterThread2 extends Thread {
    TicketBookingCounter2 thread;
    String name;
    int tickets;
    TicketCounterThread2(TicketBookingCounter2 thread, String name, int tickets) {
        this.thread = thread;
        this.name = name;
        this.tickets = tickets;
    }
    public void run() {
        thread.bookTicket(name, tickets);
    }
}

public class MultiThreadingExercise3MethodSynchronized extends Thread{
    public static void main(String[] args) {
        TicketBookingCounter2 tc = new TicketBookingCounter2();
        TicketCounterThread2 thread1 = new TicketCounterThread2(tc, "Abhishek", 1);
        TicketCounterThread2 thread2 = new TicketCounterThread2(tc, "Tarun", 1);
        TicketCounterThread2 thread3 = new TicketCounterThread2(tc, "Nikhil", 1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
//-----------------------------OUTPUT----------------------
//        Abhishek : 1 Tickets Booked Successfully
//        Nikhil : 1 Tickets Booked Successfully
//        Tarun : No Tickets are Available