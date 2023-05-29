package UD03.Boletines.Boletin2.Ej01_Profesor.model;

import java.io.Serializable;

public class Especialidad implements Serializable {
    private int id;
    private String nombreEspecialidad;

    public Especialidad() {
    }

    public Especialidad(int id, String nombreEspecialidad) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", nombreEspecialidad='" + nombreEspecialidad + '\'' +
                '}';
    }
}
