package org.example.persistencia;

import org.example.modelo.Alumno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlumnoDAO {
    private EntityManagerFactory entityManagerFactory;

    public AlumnoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("miPersistenceUnit");
    }

    public Alumno crearAlumno(Alumno alumno) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
        entityManager.close();
        return alumno;
    }

    public Alumno obtenerAlumno(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Alumno alumno = entityManager.find(Alumno.class, id);
        entityManager.close();
        return alumno;
    }

    public Alumno actualizarAlumno(Alumno alumno) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        alumno = entityManager.merge(alumno);
        entityManager.getTransaction().commit();
        entityManager.close();
        return alumno;
    }

    public boolean eliminarAlumno(long id) {
        boolean ok = false;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno alumno = entityManager.find(Alumno.class, id);
        if (alumno != null) {
            entityManager.remove(alumno);
            ok = true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return ok;
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Alumno> alumnos = entityManager.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
        entityManager.close();
        return alumnos;
    }
}