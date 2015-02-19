package es.opensigad.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno_nota")
public class AlumnoNota {
	@Id
	@GeneratedValue
	private Integer id;

	private char evaluacion;
	private int nota;
	private String observacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public char getEvaluacion() {
		return evaluacion;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void setEvaluacion(char evaluacion) {
		this.evaluacion = evaluacion;
	}

}
