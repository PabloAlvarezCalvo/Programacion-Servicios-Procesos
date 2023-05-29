package UD03.Examen.Ej02.model;

import java.io.Serializable;

public class Cargo implements Serializable {
    private String nombre;
    private String cargo = "";
    private double salario = 0d;

    public Cargo(){

    }

    public Cargo(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }


    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "EMPLEADO: " + nombre + "\n"
                + "CARGO: " + cargo + "\n"
                + "SALARIO: " + salario + "€.";
    }
}
