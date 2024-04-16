package ufps.poo2.ejercicio.banco;

import javax.management.RuntimeErrorException;

public class CDTAccount extends Account {

    private double monto = this.getBalance();
    private int meses;

    public CDTAccount(int numeroDeCuneta, double monto, int meses) {
        super(numeroDeCuneta);
        if (meses <= 0)
            throw new RuntimeException("Los mese deben de ser mayor que cero");
        this.monto = monto;
        this.meses = meses;
    }

    public CDTAccount(int numeroDeCuneta) {
        super(numeroDeCuneta);
    }

    @Override
    public void deposit(double monto) {
        System.out.println(monto);
        if (monto == 0) {
            deposit(monto);
        } else {
            throw new RuntimeException("No puede depositar");
        }
    }

    @Override
    public void withdraw(double interes) {
        for (int i = 0; i <= meses; i++) {
            monto += (((monto * interes) / 100));
        }
        System.out.println(monto);
        monto = 0;
    }
}
