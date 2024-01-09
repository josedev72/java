package org.example.controlador;

import org.example.modelo.Alumno;
import org.example.persistencia.AlumnoDAO;

import javax.persistence.EntityManager;
import java.util.List;

public class AlumnoController {

    private AlumnoDAO persiste = new AlumnoDAO();
    public Alumno crearAlumno(String nombre){
        if (nombre.trim().length() > 0) {
            Alumno alumno = new Alumno(nombre);
            return persiste.crearAlumno(alumno);
        }
        else {
            return null;
        }
    }

    public Alumno obtenerAlumno(long id) {
        return persiste.obtenerAlumno(id);
    }

    public Alumno actualizarAlumno(long id, String nombre) {
        Alumno alumno = new Alumno(nombre);
        alumno.setId(id);
        return persiste.actualizarAlumno(alumno);
    }

    public boolean eliminarAlumno(long id) {
        return persiste.eliminarAlumno(id);
    }

    public List<Alumno> listarAlumnos(){
        return persiste.obtenerTodosLosAlumnos();
    }

}
