package impl.personal;

import impl.PersistentObject;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import persistence.EmpleadoDAO;
import utils.DateUtils;
import views.personal.EmpleadoView;

@Entity
@Table(name = "Empleados")
@AttributeOverride(name = "id", column = @Column(name = "id_empleado"))
public class Empleado extends PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7671252861970388806L;

	@Column(name = "cuit")
	private String cuit;

	@Column(name = "dni")
	private String dni;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "puesto")
	@Enumerated(EnumType.STRING)
	private TipoPuesto puesto;

	public Empleado(String cuit, String dni, String nombre, String apellido, String fechaNacimiento, String puesto) {
		this.cuit = cuit;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = DateUtils.parseDate(fechaNacimiento);
		this.puesto = TipoPuesto.valueOf(puesto);
		id = EmpleadoDAO.getInstance().insert(this);
	}

	public Empleado() {

	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoPuesto getPuesto() {
		return puesto;
	}

	public void setPuesto(TipoPuesto puesto) {
		this.puesto = puesto;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EmpleadoView getView() {

		return new EmpleadoView(id, cuit, dni, nombre, apellido, fechaNacimiento.toString(),
				puesto.toString());
	}
}
