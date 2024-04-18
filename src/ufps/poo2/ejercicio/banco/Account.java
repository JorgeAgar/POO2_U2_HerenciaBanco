package ufps.poo2.ejercicio.banco;

public class Account {

	private double bal; // The current balance
	private int accnum; // The account number
	private Cliente cliente; //punto 2

	public Account(int a) {
		bal = 0.0;
		accnum = a;
	}

	//punto 2
	public Account(int a, Cliente cliente){ 
		this(a);
		this.cliente = cliente;
	}

	public void deposit(double sum) {
		if (sum > 0)
			bal += sum;
		else
			System.err.println("Account.deposit(...): " + "cannot deposit negative amount.");
	}

	public void withdraw(double sum) {
		if (sum > 0)
			bal -= sum;
		else
			System.err.println("Account.withdraw(...): " + "cannot withdraw negative amount.");
	}

	public double getBalance() {
		return bal;
	}

	public int getAccountNumber() {
		return accnum;
	}

	public String toString() {
		return "Acc " + accnum + ": " + "balance = " + bal;
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	//punto 2
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	//Método par el punto 4
	public final void setBalance(double val){
		this.bal = val;
	}

	public final void print() {
		// Don't override this,
		// override the toString method
		System.out.println(toString());
	}
	
}
