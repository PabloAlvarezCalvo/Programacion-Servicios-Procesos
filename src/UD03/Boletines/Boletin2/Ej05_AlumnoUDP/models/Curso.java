package UD03.Boletines.Boletin2.Ej05_AlumnoUDP.models;

import java.io.Serializable;

public class Curso implements Serializable {
    private long id;
    private String descripcion;

    public Curso() {
    }

    public Curso(int id) {
        this.id = id;
    }

    public Curso(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
