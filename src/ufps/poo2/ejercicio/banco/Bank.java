package ufps.poo2.ejercicio.banco;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Banco que almacena cuentas
 * @author Gabriel Pinto y Jorge Reyes
 */

public class Bank {

    private LinkedList<Account> accounts;
    private LinkedList<Cliente> clientes; //punto 3

    public Bank(){
        accounts = new LinkedList<>();
        clientes = new LinkedList<>();
    }

    /**
     * Se crea un tipo de cuenta
     * @param accType se establece el tipo de cuenta
     * @param accNumber número de cuentaa
     */
    public void openAccount(char accType, int accNumber){

        this.verificarNumeroCuenta(accNumber);

        Account newAccount;
        switch (accType) {
            case 'A' -> {
                newAccount = new SavingsAccount(accNumber);
            }
            case 'C' -> {
                newAccount = new CurrentAccount(accNumber);
            }
            case 'M' -> {
                newAccount = new MixedAccount(accNumber);
            }
            default -> {
                throw new RuntimeException("Invalid account type");
            }
        }

        if(accounts.contains(newAccount)) throw new RuntimeException("There's already an account with that number!");

        accounts.add(newAccount);
    }

    /**
     * Punto 2. Vincula una cuenta con un cliente
     * @param accNum el número de la cuenta
     * @param cedulaCliente el número de cédula del cliente
     * @param nombres los nombres del cliente
     * @param apellidos los apellidos del cliente
     */
    public void vincularCuenta(int accNum, long cedulaCliente, String nombres, String apellidos){
        Account cuenta = null;
        for (Account account : accounts) {
            if(account.getAccountNumber() == accNum){
                cuenta = account;
                break;
            }
        }
        if(cuenta == null)
            throw new RuntimeException("Cuenta inexistente");

        Cliente cliente = null;
        for (Cliente client : clientes) {
            if(client.getCedula() == cedulaCliente){
                if(!client.getApellidos().equalsIgnoreCase(apellidos) || !client.getNombres().equalsIgnoreCase(nombres)){
                    throw new RuntimeException("Nombres o apellidos inválidos");                   
                }

                cliente = client;
            }
        }

        if(cliente == null)
            cliente = new Cliente(cedulaCliente, nombres, apellidos);
        
        cliente.añadirCuenta(cuenta);
        cuenta.setCliente(cliente);
    }

    /**
     * Punto 5
     * Verifica si ya existe una cuenta registrada con el número
     * @param num el número de la cuenta
     */
    private void verificarNumeroCuenta(int num){
        for (Account account : accounts)
            if(account.getAccountNumber() == num)
                throw new RuntimeException("Ya existe una cuenta con ese número");
    }

    /**
     * Lista los clientes con su saldo
     * @return una cadena con la lista de todos los clientes
     */
    public String listarClientes(){
        String msg = "";
        for (Cliente cliente : clientes) {
            msg += cliente.toString();
            msg += "\n";
        }
        return msg;
    }

    /**
     * Abre una mixedAccount
     * @param accNum el numero de la cuenta
     * @param cedulaCliente el numero de cedula del cliente
     */
    public void openMixedAccount(int accNum, long cedulaCliente){

        this.verificarNumeroCuenta(accNum);
        Scanner sc = new Scanner(System.in);

        Cliente cliente = null;
        for (Cliente client : clientes) 
            if(client.getCedula() == cedulaCliente)
                cliente = client;
    
        if(cliente == null){
            
            System.out.println("Ingrese sus nombres");
            String nombres = sc.nextLine();
            System.out.println("Ingrese sus apellidos");
            String apellidos = sc.nextLine();
            
            cliente = new Cliente(cedulaCliente, nombres, apellidos);
            clientes.add(cliente);
        }

        System.out.println("Ingrese la cantidad de días");
        int dias = sc.nextInt();
        System.out.println("Ingrese el interés (en decimal)");
        double interes = sc.nextDouble();
        sc.close();

        MixedAccount nuevaCuenta = new MixedAccount(accNum, dias, interes);
        nuevaCuenta.setCliente(cliente);
        cliente.añadirCuenta(nuevaCuenta);

        accounts.add(nuevaCuenta);
    }

    /**
     * Se establece el interés de una cuenta de ahorros
     * @param accNumber el número de una cuenta de ahorros
     * @param newInterest el nuevo interés de la cuenta de ahorros 
     */
    public void setAccountInterest(int accNumber, double newInterest){
        if(this.getAccount(accNumber) instanceof SavingsAccount){
            SavingsAccount savingsAccount = (SavingsAccount) this.getAccount(accNumber);
            savingsAccount.setInterest(newInterest);
        }
        throw new RuntimeException("Only savings accounts have interest");
    }

    /**
     * se valida que sea de tipo cuenta ahorro y se establece ell límite
     * @param accNumber número de cuenta
     * @param newOverdraftLimit límite de sobregiro
     */
    public void setOverdraftLimit(int accNumber, double newOverdraftLimit){
        if (this.getAccount(accNumber) instanceof CurrentAccount){
            CurrentAccount currentAccount = (CurrentAccount) this.getAccount(accNumber);
            currentAccount.setOverdraftLimit(newOverdraftLimit);  
        }
        throw new RuntimeException("Only current accounts have overdraft limits");
    }

    /**
     * se retira una cantidad de la cuenta
     * @param accNumber número de la cuenta 
     * @param amount monto a reitrar
     */
    public void withdrawAccount(int accNumber, double amount){
        this.getAccount(accNumber).withdraw(amount);
    }

    /**
     * Se deposita una cantidad en la cuenta
     * @param accNumber el número de la cuenta
     * @param amount la cantidad a ingresar
     */
    public void payDividend(int accNumber, double amount){
        this.getAccount(accNumber).deposit(amount);
    }

/**
 * Se devuelve el balance de una cuenta
 * @param accNumber el número de la cuenta
 */
    public double getBalance(int accNumber){
        Account cuenta = this.getAccount(accNumber);

        if(cuenta instanceof MixedAccount){ //saldo MixedAccount Punto 1.
            MixedAccount acc = (MixedAccount)cuenta;
            System.out.println("Días: " + acc.getDias());
            double saldoTotal = acc.getBalance();

            for (int i = 0; i < acc.getDias(); i++) {
                saldoTotal += saldoTotal*acc.getInteres();
            }

            System.out.println("Ganancia: " + (saldoTotal-acc.getBalance()));
            return saldoTotal;
        }

        else return cuenta.getBalance();
    }

    /**
     * Se envía una carta a las cuentas corrientes en sobregiro
     */
    public void sendLetterToOverdraftAccounts(){
        for (Account account : accounts) {
            if(!(account instanceof CurrentAccount)) continue;
            CurrentAccount currentAcc = (CurrentAccount) account;
            if(currentAcc.isOverDraft()){
                System.out.println("Overdraft: " + currentAcc);
            }
        }
    }
    
    /**
     * cerrar una cuenta
     * @param accNumber número de la cuenta
     */
    public void closeAccount(int accNumber){
        this.accounts.remove(getAccount(accNumber));
    }
    
     /**
      * obtener la cuentra
      * @param accNum número de la cuenta
      * @return la cuenta
      */
    private Account getAccount(int accNum){
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber() == accNum){
                return accounts.get(i);
            }
        }
        throw new RuntimeException("There is no account with that number");
    }
}
