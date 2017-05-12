package tec.mediTEC.usuarios;

import java.util.ArrayList;
import java.util.List;

import te.mediTEC.medicResources.cita;

public class Doctor {
	private String nombre;
	private String correo;
	private int codigo;
	private int calificación = 5;
	private static List<cita> citas = new ArrayList<>() ;
	
	public Doctor(){
	}
	
	public Doctor(String nombre, String correo) {
		this.nombre = nombre;
		this.correo = correo;
		this.codigo = 111;
	}

	public List<cita> getCitas() {
		return citas;
	}

	public void setCitas(List<cita> citas) {
		Doctor.citas = citas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCalificación() {
		return calificación;
	}

	public void setCalificación(int calificación) {
		this.calificación = calificación;
	}
	
	
	

}
