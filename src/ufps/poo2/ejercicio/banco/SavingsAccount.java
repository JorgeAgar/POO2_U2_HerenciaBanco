package ufps.poo2.ejercicio.banco;

/**
 * Una cuenta de ahorros con interés
 * @author Jorge Andrés Reyes - jorgeandresrs@ufps.edu.co
 */

public class SavingsAccount extends Account{
    
    private double interest;

    /**
     * Construye una cuenta de ahorros con el número de cuenta y el interés especificados
     * @param accountNumber el número de la cuenta
     * @param interesBasico el interés de la cuenta
     */
    public SavingsAccount(int accountNumber, double interesBasico){
        super(accountNumber);

        if(interesBasico < 0 || interesBasico > 0.3)
            throw new RuntimeException("El interés debe ser un valor entre 0 y 0.3");

        this.interest = interesBasico;
    }

    /**
     * Construye una cuenta de ahorros con el número de cuenta especificado y con interés de 0
     * @param accountNumber el número de la cuenta
     */
    public SavingsAccount(int accountNumber){
        this(accountNumber, 0);
    }

    /**
     * Deposita una cantidad de dinero en la cuenta y le suma el interés
     * @param sum el monto a depositar
     */
    @Override
    public void deposit(double sum){
        double interes = super.getBalance() * this.interest;
        super.deposit(sum + interes);
    }

    public void setInterest(double newInterest){
        if(newInterest < 0 || newInterest > 0.3)
            throw new RuntimeException("El interés debe ser un valor entre 0 y 0.3");
        this.interest = newInterest;
    }

    @Override
    public String toString(){
        return "Savings " + super.toString();
    }

}
