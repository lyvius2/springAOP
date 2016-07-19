package sample1;

public interface BankAccountService {

	void createAccount(AccountDetail detail, String accountType);
	
	void deleteAccount(AccountDetail detail);
}
