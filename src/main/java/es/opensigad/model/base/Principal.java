package es.opensigad.model.base;

import javax.persistence.EntityManager;

import es.opensigad.model.vo.AlumnoNota;

public class Principal {

	public static void main(String[] args) {

		AlumnoNota alumno = new AlumnoNota();
		alumno.setEvaluacion('1');
		alumno.setNota(4);
		alumno.setObservacion("Suspenso");

		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(alumno);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
		
	}

}
