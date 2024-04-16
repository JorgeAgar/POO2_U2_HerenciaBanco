package ufps.poo2.ejercicio.test;

import ufps.poo2.ejercicio.banco.CDTAccount;

public class PruebaCDT {
    public static void main(String[] args) {
        CDTAccount c = new CDTAccount(123, 0, 3);

        c.deposit(100);
        c.withdraw(10);

    }

}
