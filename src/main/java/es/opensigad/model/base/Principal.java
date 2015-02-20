package es.opensigad.model.base;

import javax.persistence.EntityManager;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;

public class Principal {

	public static void main(String[] args) {
		
		// --------- Alumno Matricula ----------//
		AlumnoMatricula alumnoMatricula =new AlumnoMatricula();
		alumnoMatricula.setId(1);
		
		// --------- Enseñanza Materia ----------//
		EnsenanzaMateria ensenanzaMateria=new EnsenanzaMateria();
		ensenanzaMateria.setId(1);
		
		// --------- Alumno ----------//
		Alumno al=new Alumno();
		al.setId(1);
		al.setSexo("h");
		
		// --------- Alumno Nota ----------//
		AlumnoNota alumno = new AlumnoNota();
		alumno.setAlumnoMatricula(alumnoMatricula);
		alumno.setEnsenanzaMateria(ensenanzaMateria);
		alumno.setEvaluacion("1");
		alumno.setNota(10);
		alumno.setObservacion("¡¡Perfecto un 10!!");

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(al);
		em.persist(alumno);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
		
	}

}
