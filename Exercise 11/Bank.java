// A simple Bank Account program using Inter-thread Communication
class BankAccount {
    private int balance = 0;

    // Deposit money into the account
    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        System.out.println("Current Balance: " + balance);
        notify(); // Notify waiting thread (if any)
    }

    // Withdraw money from the account
    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to withdraw: " + amount);

        // Wait if there isn't enough balance
        while (balance < amount) {
            System.out.println("Insufficient balance! " + Thread.currentThread().getName() + " is waiting...");
            try {
                wait(); // Wait until someone deposits money
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        // Perform withdrawal
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        System.out.println("Current Balance: " + balance);
    }
}

class DepositThread extends Thread {
    private BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        int[] deposits = {1000, 2000, 1500};
        for (int amount : deposits) {
            account.deposit(amount);
            try {
                Thread.sleep(500); // Simulate time between deposits
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        int[] withdrawals = {500, 4000, 1000};
        for (int amount : withdrawals) {
            account.withdraw(amount);
            try {
                Thread.sleep(800); // Simulate time between withdrawals
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Bank{
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        DepositThread depositor = new DepositThread(account);
        WithdrawThread withdrawer = new WithdrawThread(account);

        depositor.setName("Depositor");
        withdrawer.setName("Withdrawer");

        depositor.start();
        withdrawer.start();
    }
}

