package UD03.Boletines.Boletin2.Ej01_Profesor.model;

import java.io.Serializable;
import java.util.Arrays;

public class Profesor implements Serializable {
    private int idProfesor;
    private String nombre;
    private Asignatura[] asignaturas;
    private Especialidad especialidad;

    public Profesor() {
    }

    public Profesor(int idProfesor, String nombre) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        if (asignaturas.length <= 3)
            this.asignaturas = asignaturas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad.getNombreEspecialidad() +
                ", asignaturas=" + Arrays.toString(asignaturas) +
                '}';
    }
}
