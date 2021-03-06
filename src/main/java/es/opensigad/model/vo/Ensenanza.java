package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ensenanza database table.
 * 
 */
@Entity
@Table(name="ensenanza")
@NamedQuery(name="Ensenanza.findAll", query="SELECT e FROM Ensenanza e")
public class Ensenanza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="codigo_registro", length=45)
	private String codigoRegistro;

	private int horas;

	@Column(length=45)
	private String nombre;

	//bi-directional many-to-one association to AlumnoMatricula
	@OneToMany(mappedBy="ensenanza")
	private List<AlumnoMatricula> alumnoMatriculas;

	//bi-directional many-to-one association to EnsenanzaTipo
	@ManyToOne
	@JoinColumn(name="id_ensenanza_tipo")
	private EnsenanzaTipo ensenanzaTipo;

	//bi-directional many-to-one association to EnsenanzaCiclo
	@OneToMany(mappedBy="ensenanza")
	private List<EnsenanzaCiclo> ensenanzaCiclos;

	public Ensenanza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoRegistro() {
		return this.codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public int getHoras() {
		return this.horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AlumnoMatricula> getAlumnoMatriculas() {
		return this.alumnoMatriculas;
	}

	public void setAlumnoMatriculas(List<AlumnoMatricula> alumnoMatriculas) {
		this.alumnoMatriculas = alumnoMatriculas;
	}

	public AlumnoMatricula addAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		getAlumnoMatriculas().add(alumnoMatricula);
		alumnoMatricula.setEnsenanza(this);

		return alumnoMatricula;
	}

	public AlumnoMatricula removeAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		getAlumnoMatriculas().remove(alumnoMatricula);
		alumnoMatricula.setEnsenanza(null);

		return alumnoMatricula;
	}

	public EnsenanzaTipo getEnsenanzaTipo() {
		return this.ensenanzaTipo;
	}

	public void setEnsenanzaTipo(EnsenanzaTipo ensenanzaTipo) {
		this.ensenanzaTipo = ensenanzaTipo;
	}

	public List<EnsenanzaCiclo> getEnsenanzaCiclos() {
		return this.ensenanzaCiclos;
	}

	public void setEnsenanzaCiclos(List<EnsenanzaCiclo> ensenanzaCiclos) {
		this.ensenanzaCiclos = ensenanzaCiclos;
	}

	public EnsenanzaCiclo addEnsenanzaCiclo(EnsenanzaCiclo ensenanzaCiclo) {
		getEnsenanzaCiclos().add(ensenanzaCiclo);
		ensenanzaCiclo.setEnsenanza(this);

		return ensenanzaCiclo;
	}

	public EnsenanzaCiclo removeEnsenanzaCiclo(EnsenanzaCiclo ensenanzaCiclo) {
		getEnsenanzaCiclos().remove(ensenanzaCiclo);
		ensenanzaCiclo.setEnsenanza(null);

		return ensenanzaCiclo;
	}

}