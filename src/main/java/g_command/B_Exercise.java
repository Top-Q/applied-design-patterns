package g_command;


/**
 * Implement the Account.process() method to process different account commands. The rules are obvious:
 *
 * success indicates whether the operation was successful
 * You can only withdraw money if you have enough in your account
 */
class Command1
{
    enum Action1
    {
        DEPOSIT, WITHDRAW
    }

    public Action1 action;
    public int amount;
    public boolean success;

    public Command1(Action1 action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }
}

class Account
{
    public int balance;

    public void process(Command1 c)
    {
        // todo
    }
}