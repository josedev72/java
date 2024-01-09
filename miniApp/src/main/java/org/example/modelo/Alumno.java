package org.example.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    public Alumno() {
    }

    public Alumno(String nombre) {
        //this.id = id;
        this.nombre = nombre;
    }

    // Constructor, getters y setters


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

    @Override
    public String toString() {
        return "Alumno{ " +
                "id = " + id +
                ", nombre = '" + nombre + '\'' +
                " }";
    }
}