package g_command;
/**
 * Implement the Account.process() method to process different account commands. The rules are obvious:
 *
 * success indicates whether the operation was successful
 * You can only withdraw money if you have enough in your account
 */
class Command2
{
    enum Action1
    {
        DEPOSIT, WITHDRAW
    }

    public Action1 action;
    public int amount;
    public boolean success;

    public Command2(Action1 action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }
}

class Account2
{
    public int balance;

    public void process(Command2 c)
    {
        switch (c.action) {
            case DEPOSIT:
                balance += c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                if (balance >= c.amount) {
                    balance -= c.amount;
                    c.success = true;
                } else {
                    c.success = false;
                }
                break;
        }
    }
}