package ufps.poo2.ejercicio.banco;

import java.util.LinkedList;

public class Bank {

    private LinkedList<Account> accounts;

    public Bank(){
        accounts = new LinkedList<>();
    }

    public void openAccount(char accType, int accNumber){
        Account newAccount;
        switch (accType) {
            case 'A' -> {
                newAccount = new SavingsAccount(accNumber);
            }
            case 'C' -> {
                newAccount = new CurrentAccount(accNumber);
            }
            default -> {
                throw new RuntimeException("Invalid account type");
            }
        }

        if(accounts.contains(newAccount)) throw new RuntimeException("There's already an account with that number!");

        accounts.add(newAccount);
    }

    public void setAccountInterest(int accNumber, double newInterest){
        if(this.getAccount(accNumber) instanceof SavingsAccount){
            SavingsAccount savingsAccount = (SavingsAccount) this.getAccount(accNumber);
            savingsAccount.setInterest(newInterest);
        }
        throw new RuntimeException("Only savings accounts have interest");
    }

    public void setOverdraftLimit(int accNumber, double newOverdraftLimit){
        if (this.getAccount(accNumber) instanceof CurrentAccount){
            CurrentAccount currentAccount = (CurrentAccount) this.getAccount(accNumber);
            currentAccount.setOverdraftLimit(newOverdraftLimit);  
        }
        throw new RuntimeException("Only current accounts have overdraft limits");
    }

    public void withdrawAccount(int accNumber, double amount){
        this.getAccount(accNumber).withdraw(amount);
    }

    public void payDividend(int accNumber, double amount){
        this.getAccount(accNumber).deposit(amount);
    }

    public double getBalance(int accNumber){
        return this.getAccount(accNumber).getBalance();
    }

    public void sendLetterToOverdraftAccounts(){
        for (Account account : accounts) {
            if(!(account instanceof CurrentAccount)) continue;
            CurrentAccount currentAcc = (CurrentAccount) account;
            if(currentAcc.isOverDraft()){
                System.out.println("Overdraft: " + currentAcc);
            }
        }
    }

    public void closeAccount(int accNumber){
        this.accounts.remove(getAccount(accNumber));
    }

    private Account getAccount(int accNum){
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber() == accNum){
                return accounts.get(i);
            }
        }
        throw new RuntimeException("There is no account with that number");
    }
}
