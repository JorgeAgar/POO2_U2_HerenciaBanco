package ufps.poo2.ejercicio.test;

import ufps.poo2.ejercicio.banco.Bank;

public class TestMixedAccount {
    public static void main(String[] args) {
        Bank banco = new Bank();

        banco.openMixedAccount(123, 123456);
        banco.payDividend(123, 1000);
        System.out.println(banco.getBalance(123));
        
        banco.openAccount('C', 321);
        banco.vincularCuenta(321, 123456, "Pepito", "Pérez");
        banco.payDividend(321, 100);
        
        banco.openAccount('A', 789);
        banco.vincularCuenta(789, 654, "Pedro", "Picapiedra");
        banco.payDividend(789, 100);

        System.out.println(banco.listarClientes());
    }
}
