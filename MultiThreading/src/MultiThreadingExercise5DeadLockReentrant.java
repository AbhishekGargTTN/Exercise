//Q5. Write a program to simulate a deadlock in java and then improve the
//        program to handle the deadlock using reentrant lock.

import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadingExercise5DeadLockReentrant {
    public static void main(String[] args) throws InterruptedException {
        MultiThreadingExercise5DeadLockReentrant reentrantLockExample = new MultiThreadingExercise5DeadLockReentrant();
        Account2 account1 = new Account2("12345", 10000);
        Account2 account2 = new Account2("98765", 20000);
        Thread t1 = new Thread(() -> {
                reentrantLockExample.lock(account1, account2);
                reentrantLockExample.transfer(account1, account2, 1000);
                reentrantLockExample.unLock(account1, account2);
        });
        Thread t2 = new Thread(() -> {
                reentrantLockExample.lock(account2, account1);
                reentrantLockExample.transfer(account2, account1, 500);
                reentrantLockExample.unLock(account2, account1);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total balance for account1: " + account1.getAmount());
        System.out.println("Total balance for account2: " + account2.getAmount());

    }

    private void transfer(Account2 fromAccount, Account2 toAccount, Integer amount) {
        System.out.println("Transferring amount: " + amount + " from account: " + fromAccount.getAccountNumber() + " to account: " + toAccount.getAccountNumber());
        toAccount.setAmount(toAccount.getAmount() - amount);
        fromAccount.setAmount(fromAccount.getAmount() + amount);
    }

    private void lock(Account2 fromAccount, Account2 toAccount) {
        while (true) {
            Boolean fromAccountLocked = fromAccount.getLock().tryLock();
            Boolean toAccountLocked = toAccount.getLock().tryLock();
            if (fromAccountLocked && toAccountLocked) {
                return;
            }
            if(fromAccountLocked) {
                fromAccount.getLock().unlock();
            }
            if(toAccountLocked) {
                toAccount.getLock().unlock();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void unLock(Account2 fromAccount, Account2 toAccount) {
        fromAccount.getLock().unlock();
        toAccount.getLock().unlock();
    }
}

class Account2 {
    private String accountNumber;
    private Integer amount;
    private ReentrantLock lock;

    public Account2(String accountNumber, Integer amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.lock = new ReentrantLock();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
//------------------------OUTPUT-----------------
//        Transferring amount: 1000 from account: 12345 to account: 98765
//        Transferring amount: 500 from account: 98765 to account: 12345
//        Total balance for account1: 10500
//        Total balance for account2: 19500