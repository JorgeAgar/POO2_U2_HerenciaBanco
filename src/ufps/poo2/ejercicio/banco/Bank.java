package ufps.poo2.ejercicio.banco;

import java.util.LinkedList;

/**
 * Banco que almacena cuentas
 * 
 * @author Gabriel Pinto y Jorge Reyes
 */

public class Bank {

    private LinkedList<Account> accounts;

    private double interes;

    public Bank() {
        accounts = new LinkedList<>();
    }

    /**
     * Se crea un tipo de cuenta
     * 
     * @param accType   se establece el tipo de cuenta
     * @param accNumber número de cuentaa
     */
    public void openAccount(char accType, int accNumber) {
        Account newAccount;
        switch (accType) {
            case 'A' -> {
                newAccount = new SavingsAccount(accNumber);
            }
            case 'C' -> {
                newAccount = new CurrentAccount(accNumber);
            }
            case 'I' -> {
                newAccount = new CDTAccount(accNumber);
            }
            default -> {
                throw new RuntimeException("Invalid account type");
            }
        }

        if (accounts.contains(newAccount))
            throw new RuntimeException("There's already an account with that number!");

        accounts.add(newAccount);
    }

    /**
     * Se establece el interés de una cuenta de ahorros
     * 
     * @param accNumber   el número de una cuenta de ahorros
     * @param newInterest el nuevo interés de la cuenta de ahorros
     */
    public void setAccountInterest(int accNumber, double newInterest) {
        if (this.getAccount(accNumber) instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) this.getAccount(accNumber);
            savingsAccount.setInterest(newInterest);
        }
        throw new RuntimeException("Only savings accounts have interest");
    }

    /**
     * se valida que sea de tipo cuenta ahorro y se establece ell límite
     * 
     * @param accNumber         número de cuenta
     * @param newOverdraftLimit límite de sobregiro
     */
    public void setOverdraftLimit(int accNumber, double newOverdraftLimit) {
        if (this.getAccount(accNumber) instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) this.getAccount(accNumber);
            currentAccount.setOverdraftLimit(newOverdraftLimit);
        }
        throw new RuntimeException("Only current accounts have overdraft limits");
    }

    /**
     * se retira una cantidad de la cuenta
     * 
     * @param accNumber número de la cuenta
     * @param amount    monto a reitrar
     */
    public void withdrawAccount(int accNumber, double amount) {
        this.getAccount(accNumber).withdraw(amount);
    }

    public void withdrawAccountCDT(int accNumber) {
        if (this.getAccount(accNumber) instanceof CDTAccount) {
            this.getAccount(accNumber).withdraw(interes);
        } else {
            throw new RuntimeException("No es un tipo de cuenta CDT");
        }

    }

    /**
     * Se deposita una cantidad en la cuenta
     * 
     * @param accNumber el número de la cuenta
     * @param amount    la cantidad a ingresar
     */
    public void payDividend(int accNumber, double amount) {
        this.getAccount(accNumber).deposit(amount);
    }

    /**
     * Se devuelve el balance de una cuenta
     * 
     * @param accNumber el número de la cuenta
     */
    public double getBalance(int accNumber) {
        return this.getAccount(accNumber).getBalance();
    }

    /**
     * Se envía una carta a las cuentas corrientes en sobregiro
     */
    public void sendLetterToOverdraftAccounts() {
        for (Account account : accounts) {
            if (!(account instanceof CurrentAccount))
                continue;
            CurrentAccount currentAcc = (CurrentAccount) account;
            if (currentAcc.isOverDraft()) {
                System.out.println("Overdraft: " + currentAcc);
            }
        }
    }

    /**
     * cerrar una cuenta
     * 
     * @param accNumber número de la cuenta
     */
    public void closeAccount(int accNumber) {
        this.accounts.remove(getAccount(accNumber));
    }

    /**
     * obtener la cuentra
     * 
     * @param accNum número de la cuenta
     * @return la cuenta
     */
    private Account getAccount(int accNum) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accNum) {
                return accounts.get(i);
            }
        }
        throw new RuntimeException("There is no account with that number");
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        if (this.interes < 0)
            throw new RuntimeException("El interes no debe ser negativo");
        this.interes = interes;
    }
}
