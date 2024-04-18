package ufps.poo2.ejercicio.banco;

public class MixedAccount extends Account{
    private int dias;
    private double interes;

    public MixedAccount(int numeroCuenta){
        super(numeroCuenta);
    }

    public MixedAccount(int numCuenta, int dias, double interes){
        super(numCuenta);
        if(dias <= 0)
            throw new RuntimeException("La cantidad de días debe ser mayor a 0");
        if(interes <= 0)
            throw new RuntimeException("El interés debe ser mayor a 0");
        this.dias = dias;
        this.interes = interes;
    }

    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public double getInteres() {
        return interes;
    }
    public void setInteres(double interes) {
        this.interes = interes;
    }

    
}
