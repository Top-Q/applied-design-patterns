package g_command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BankAccount {

    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", balance is now " + balance);
            return true;
        }
        System.out.println("Cannot withdraw " + amount + ", balance is now " + balance);
        return false;
    }

    public String toString() {
        return "Balance: " + balance;
    }
}

// Want to process things differently. We want to audit the transactions.
interface Command {
    void call();
    void undo();
}

class BankAccountCommand implements Command {

    private BankAccount account;

    public enum Action {
        DEPOSIT, WITHDRAW
    }

    private Action action;
    private int amount;
    private boolean succeeded = true;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }


    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    public void undo() {
        if (!succeeded) return;
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }

}

class CommandDemo {

        public static void main(String[] args) {
            BankAccount ba = new BankAccount();
            System.out.println(ba); //0
            List<BankAccountCommand> commands = Arrays.asList(
                    new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100), //100
                    new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000) // We can't withdraw more than 600
            );
            for (BankAccountCommand c : commands) {
                c.call();
                System.out.println(ba);
            }

            System.out.println("Undoing commands");

            Collections.reverse(commands);
            for (Command c : commands) {
                c.undo();
                System.out.println(ba);
            }
            System.out.println("Final balance:");
            System.out.println(ba);

        }
}