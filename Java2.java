// Q. Implement a banking system using java.
//
//         Create 3 sub class of Bank : SBI,BOI,ICICI
//
//         All 4 should have following methods:
//
//         getDetails which provide their specific details like rateofinterest etc
//         printDetails of every bank.
//         Every bank account should have a type (enum): SAVINGS, CURRENT
//         Implement a feature to deduct amount from account. Throw InsufficientAmountException
//         if amount being deducted is less than the current balance.
//         Every banking transaction should be saved in a file of each bank's transaction
//         log which would have all details of the transaction
//         like (time of transaction,account number,amount withdrawn,
//         amount before deduction, amount after deduction,transaction status
//         (can also be enum), failure reason if any)

import java.math.BigInteger;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class InsufficientAmountException extends Exception {
    public InsufficientAmountException(String message) {
        super(message);
    }
}
 class Bank implements bank {
    private String bankName;
    private double rateOfInterest;
    private ArrayList<Account> accountList = new ArrayList<Account>();
    public Bank(String bankName,double rateOfInterest) {
        this.bankName=bankName;
        this.rateOfInterest=rateOfInterest;
        try {
            File fileObject = new File(bankName+"_transaction_log.txt");
            if (fileObject.createNewFile()) {
                System.out.println("File created: " + fileObject.getName());
            }
        } catch (IOException e) {}
    }
    public ArrayList<Account> getAccountList() {
        return accountList;
    }
    @Override
    public boolean registerAccount(Account account) {
        accountList.add(account);
        setTransaction_log("Account Number - " + account.getAccountNumber() + " is registered");
        return true;
    }
    @Override
    public void getDetails() {
        System.out.println("Bank : "+bankName);
        System.out.println("Interest Rate "+rateOfInterest);
    }
    public void getTransaction_log() {
        try(Scanner scanner = new Scanner(new File(bankName+"_transaction_log.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setTransaction_log(String transaction) {
        try(PrintWriter writer = new PrintWriter(bankName+"_transaction_log.txt")) {
            writer.println(transaction);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Account getAccount(String accountNumber){
        Account account=null;
        BigInteger temp = new BigInteger(accountNumber);
        for(Account accountIterator : accountList) {
            if(temp.equals( accountIterator.getAccountNumber() ) ) {
                account= accountIterator;
            }
        }
        return account;
    }
    @Override
    public void deductAmount(Account account,double deductAmount) {
        double balance =account.getBalance();
        try {
            if(balance>deductAmount){
                double new_balance=balance-deductAmount;
                account.setBalance(new_balance);
                setTransaction_log("On "+new Date()+"From - "+account.getAccountNumber()+" Balance "+balance+" Amount withdrawl - "+deductAmount+" Left Balance - "+account.getBalance());
                account.setStatement("On "+new Date()+"From - "+account.getAccountNumber()+" Balance "+balance+" Amount withdrawl - "+deductAmount+" Left Balance - "+account.getBalance());
            }
            else {
                throw new InsufficientAmountException("Exception");
            }
        }
        catch (InsufficientAmountException e) {
//            System.out.println("Transaction Failed as withdraw amount is greater than available amount");
            setTransaction_log("On "+new Date()+"From - "+account.getAccountNumber()+" Balance "+balance+" Left Balance - "+account.getBalance()+" Transaction Failed as withdraw amount is greater than available amount");
            account.setStatement("On "+new Date()+"From - "+account.getAccountNumber()+" Balance "+balance+" Left Balance - "+account.getBalance()+" Transaction Failed as withdraw amount is greater than available amount");
        }
    }
    @Override
    public void addAmount(Account account,double addAmount) {
        double balance=account.getBalance();
        double newBalance=balance+addAmount;
        account.setBalance(newBalance);
        setTransaction_log("On "+new Date()+"To - "+account.getAccountNumber()+" Balance "+balance+" Amount deposited - "+addAmount+" New Balance - "+account.getBalance());
        account.setStatement("On "+new Date()+"To - "+account.getAccountNumber()+" Balance "+balance+" Amount deposited - "+addAmount+" New Balance - "+account.getBalance());
    }
}
 class Account {
    private BigInteger accountNumber;
    private String ifsc;
    private String name;
    private String address;
    private double balance;
    private Type type;
    private ArrayList<String> bankStatement = new ArrayList<String>();
    Date date ;
    public Account(String accountNumber,String ifsc, Type type,String name,String address) {
        this.accountNumber=new BigInteger(accountNumber);
        this.ifsc=ifsc;
        this.type=type;
        this.name=name;
        this.address=address;
        date= new Date();
        setStatement("Account Created on "+ date);
    }
    public BigInteger getAccountNumber() {
        return accountNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public ArrayList<String> getStatement() {
        return bankStatement;
    }
    public void setStatement(String detail) {
        bankStatement.add(detail);
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public String getIfsc() {
        return ifsc;
    }
    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
    public void getAccountDetails() {
        System.out.println("Account Number : "+getAccountNumber());
        System.out.println("IFSC : "+getIfsc());
        System.out.println("Type : "+getType());
        System.out.println("Name : "+getName());
        System.out.println("Address : "+getAddress());
        System.out.println("Balance : "+getBalance());
    }
}
 class AccountNotFound extends Exception {
    public AccountNotFound() {
        super("Account Not Found");
    }
}
 class BOI extends Bank {
    public BOI(String bankName, double rateOfInterest) {
        super(bankName, rateOfInterest);
    }
    private static BOI account = null;
    public static BOI printDetails() {
        if(account == null) {
            account = new BOI("BOI",4.0);
        }
        return account;
    }
}
 class ICICI extends Bank {
    public ICICI(String bankName, double rateOfInterest) {
        super(bankName, rateOfInterest);
    }
    private static ICICI account = null;
    public static ICICI printDetails() {
        if(account == null) {
            account = new ICICI("ICICI",4.0);
        }
        return account;
    }
}
 class SBI extends Bank {
    public SBI(String bankName, double rateOfInterest) {
        super(bankName, rateOfInterest);
    }
    private static SBI account = null;
    public static SBI printDetails() {
        if(account == null) {
            account = new SBI("SBI",3.0);
        }
        return account;
    }
}
 enum Type {
    SAVINGS, CURRENT;
}
 interface bank {
    Account getAccount(String accountNumber);
    void getDetails();
    boolean registerAccount(Account account);
    public void addAmount(Account account,double addAmount);
    public void deductAmount(Account account,double deductAmount);
}
public class Java2 {
    public static void main(String[] args) {
        Bank sbi = SBI.printDetails();
        Account sbi1 = new Account("1234567890","SBI1234",Type.SAVINGS,"Abhishek Garg","Delhi");
        sbi.registerAccount(sbi1);
        sbi.getDetails();
        sbi.getAccount("1234567890").getAccountDetails();
        sbi.addAmount(sbi1,1000);
        sbi.deductAmount(sbi1, 100);
        System.out.println("-------bank accunt statements------");
        for(String statement : sbi.getAccount("1234567890").getStatement()) {
            System.out.println(statement);
        }
        Bank icici = ICICI.printDetails();
        Account icici1 = new Account("0987654321","ICICI1234",Type.CURRENT,"Tarun Singh","Delhi");
        icici.registerAccount(icici1);
        icici.getDetails();
        icici.getAccount("0987654321").getAccountDetails();
        icici.addAmount(icici1,1000);
        icici.deductAmount(icici1, 1100);
        System.out.println("-------bank accunt statements------");
        for(String statement : icici.getAccount("0987654321").getStatement()) {
            System.out.println(statement);
        }
    }
}
//---------------------------------OUTPUT-------------------------
//        Bank : SBI
//        Interest Rate 3.0
//        Account Number : 1234567890
//        IFSC : SBI1234
//        Type : SAVINGS
//        Name : Abhishek Garg
//        Address : Delhi
//        Balance : 0.0
//        -------bank accunt statements------
//        Account Created on Sun Oct 02 14:24:20 IST 2022
//        On Sun Oct 02 14:24:20 IST 2022To - 1234567890 Balance 0.0 Amount deposited - 1000.0 New Balance - 1000.0
//        On Sun Oct 02 14:24:20 IST 2022From - 1234567890 Balance 1000.0 Amount withdrawl - 100.0 Left Balance - 900.0
//        File created: ICICI_transaction_log.txt
//        Bank : ICICI
//        Interest Rate 4.0
//        Account Number : 987654321
//        IFSC : ICICI1234
//        Type : CURRENT
//        Name : Tarun Singh
//        Address : Delhi
//        Balance : 0.0
//        -------bank accunt statements------
//        Account Created on Sun Oct 02 14:24:20 IST 2022
//        On Sun Oct 02 14:24:20 IST 2022To - 987654321 Balance 0.0 Amount deposited - 1000.0 New Balance - 1000.0
//        On Sun Oct 02 14:24:20 IST 2022From - 987654321 Balance 1000.0 Left Balance - 1000.0 Transaction Failed as withdraw amount is greater than available amount