package ufps.poo2.ejercicio.banco;

import java.util.LinkedList;

public class Cliente {
    private long cedula;
    private String nombres;
    private String apellidos;
    private LinkedList<Account> cuentas; //punto3
    
    public Cliente(long cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        cuentas = new LinkedList<Account>();
    }

    //punto 3
    public void añadirCuenta(Account a){
        if(a == null)
            throw new RuntimeException("La cuenta es nula");
        if(a.getCliente() != null && !a.getCliente().equals(this))
            throw new RuntimeException("Esta cuenta ya está asociada a otra persona");

        
    }

    public double getSaldo(){
        double saldo = 0;
        for (Account account : cuentas) {
            saldo += account.getBalance();
        }
        return saldo;
    }

    public long getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cedula != other.cedula)
            return false;
        return true;
    }

    @Override
    public String toString(){
        String msg = "Cliente: ";
        msg += this.nombres + " " + this.apellidos + "\n";
        msg += "CC: " + this.cedula + "\n";
        msg += "Saldo: " + this.getSaldo();
        return msg;
    }
}
