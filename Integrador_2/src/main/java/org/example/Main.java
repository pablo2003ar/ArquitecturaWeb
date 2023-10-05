package org.example;

import Entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*
        Estudiante e1 = new Estudiante(17258741, "Paola","Barragan",45,"Olavarria", "F");
        em.createNativeQuery("INSERT INTO estudiante (dni, nombre, apellido, edad, ciudad, genero) VALUES (?,?,?,?,?,?)")
                .setParameter(1, e1.getDni())
                .setParameter(2, e1.getNombre())
                .setParameter(3, e1.getApellido())
                .setParameter(4, e1.getEdad())
                .setParameter(5, e1.getCiudad())
                .setParameter(6, e1.getGenero())
                .executeUpdate();

         */



        /*
        Carrera c1 = new Carrera("Tecnicatura Universitaria en Desarrollo de Aplicaciones Informáticas");
        em.persist(c1);
        Carrera c2 = new Carrera("Ingeniería de Sistemas");
        em.persist(c2);
        Carrera c3 = new Carrera("Profesorado de Informática");
        em.persist(c3);
        Carrera c4 = new Carrera("Tecnicatura Universitaria en Administración de Redes Informáticas");
        em.persist(c4);

         */




        /*
        Estudiante e1 = em.find(Estudiante.class, 4);
        Carrera c1 = em.find(Carrera.class, 3);
        Date fecha = new Date();
        Inscripciones i1 = new Inscripciones(e1,c1,false,new Timestamp(fecha.getTime()),0);
        em.createNativeQuery("INSERT INTO inscripciones (antiguedad, fechaInscripcion, graduado, id_carrera_id, nroLibreta_nroLibreta ) VALUES (?,?,?,?,?)")
                .setParameter(1, i1.getAntiguedad())
                .setParameter(2, i1.getFechaInscripcion())
                .setParameter(3, i1.isGraduado())
                .setParameter(4, i1.getId_carrera())
                .setParameter(5, i1.getNroLibreta())
                .executeUpdate();

         */



        /*
        String jpql = "SELECT e FROM Estudiante e ORDER BY e.apellido ";
        Query query = em.createQuery(jpql);
        List<Estudiante> resultados = query.getResultList();
        System.out.println(resultados);

         */

        /*
        String jpql = "SELECT e FROM Estudiante e WHERE e.nroLibreta = ?1 ";
        Query query = em.createQuery(jpql).setParameter(1,10);
        Estudiante resultado = (Estudiante) query.getSingleResult();
        System.out.println(resultado);

         */


        /*
        String jpql = "SELECT e FROM Estudiante e WHERE e.genero = ?1 ";
        Query query = em.createQuery(jpql).setParameter(1,"f");
        List<Estudiante> resultados = query.getResultList();
        System.out.println(resultados);

         */

        /*
        String jpql = "SELECT i.id_carrera FROM Inscripciones i GROUP BY i.id_carrera ORDER BY COUNT(i.id_carrera) DESC ";
        Query query = em.createQuery(jpql);
        List<Carrera> resultados = query.getResultList();
        System.out.println(resultados);

         */

        String jpql = "SELECT i.nroLibreta FROM Inscripciones i JOIN i.nroLibreta e JOIN i.id_carrera c WHERE c.id = ?1 AND e.ciudad = ?2";
        Query query = em.createQuery(jpql).setParameter(1,4).setParameter(2,"Olavarria");
        List<Estudiante> resultados = query.getResultList();
        System.out.println(resultados);






        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}