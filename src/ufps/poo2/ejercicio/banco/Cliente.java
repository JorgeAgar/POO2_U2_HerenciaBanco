package ufps.poo2.ejercicio.banco;

public class Cliente {
    private long cedula;
    private String nombres;
    private String apellidos;
    
    public Cliente(long cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
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
        if (nombres == null) {
            if (other.nombres != null)
                return false;
        } else if (!nombres.equalsIgnoreCase(other.nombres))
            return false;
        if (apellidos == null) {
            if (other.apellidos != null)
                return false;
        } else if (!apellidos.equalsIgnoreCase(other.apellidos))
            return false;
        return true;
    }

    @Override
    public String toString(){
        String msg = "Cliente: ";
        msg += this.nombres + " " + this.apellidos + "\n";
        msg += "CC: " + this.cedula;
        return msg;
    }
}
