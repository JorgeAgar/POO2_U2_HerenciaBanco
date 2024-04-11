package ufps.poo2.ejercicio.banco;
/**
 * @author Gabriel Pinto - gabrielcamilopian@ufps.edu.co
 */
public class CurrentAccount extends Account{

    private double overdraftLimit;

    /**
     * se crea una cuenta con el limite de sobregir
     * @param accountNumber Número de cuenta
     * @param overdraftLimit Porcentaje de límite de sobregiro
     */
    public CurrentAccount(int accountNumber, double overdraftLimit){
        super(accountNumber);

        if ( overdraftLimit < 0) throw new RuntimeException("El sobregiro debe de ser mayor que sero");
        this.overdraftLimit = overdraftLimit;
    }

    
    /**
     * crear cuenta con límite de sobregiro 0
     * @param account  cuenta de banco
     */
    public CurrentAccount(int account){
        this(account , 0);
    } 


    /**
     * se verifica si está en sobregiro
     * @return True si esta sobregirada y false si no está sobregirada
     */
    public boolean isOverDraft(){
        return this.getBalance() < 0 ;
    }

    /**
     * se realiza retiro
     * @param sum cantidad a retirar
     */
    @Override
    public void withdraw(double sum){
        if((this.getBalance() - (sum)) >= overdraftLimit*getBalance())
        super.withdraw(sum);
    }
    /**
     * se imprime toString
     */
    @Override
    public String toString(){
        return "Current " + super.toString();
    }
}
