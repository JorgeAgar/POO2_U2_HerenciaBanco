package factories;
import modelo.Account;
import modelo.SavingsAccount;

public class SavingsAccountFactory implements AccountFactory{

    private static final SavingsAccountFactory instance = new SavingsAccountFactory();

    private SavingsAccountFactory(){}

    @Override
    public Account createAccount(int accountNumber){
        return new SavingsAccount(accountNumber);
    }

    public static SavingsAccountFactory getInstance(){
        return instance;
    }
}
