package UD03.Boletines.Boletin2.Ej05_AlumnoUDP.models;

import java.io.Serializable;

public class Alumno implements Serializable {
    private long id;
    private String nombre;
    private Curso curso;
    private int nota;

    public Alumno() {
    }

    public Alumno(long id) {
        this.id = id;
    }

    public Alumno(long id, String nombre, Curso curso, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", nota=" + nota +
                '}';
    }
}
