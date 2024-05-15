package factories;
import modelo.CurrentAccount;
import modelo.Account;

public class CurrentAccountFactory implements AccountFactory{
	
	private static final CurrentAccountFactory instance = new CurrentAccountFactory();
	
	private CurrentAccountFactory(){}
	
	@Override
	public Account createAccount(int accountNumber){
		return new CurrentAccount(accountNumber);
	}
	
	public static CurrentAccountFactory getInstance(){
		return instance;
	}
}
