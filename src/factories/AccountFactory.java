package factories;
import modelo.Account;

public interface AccountFactory {
	public Account createAccount(int accountNumber);
}
