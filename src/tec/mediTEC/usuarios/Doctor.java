package tec.mediTEC.usuarios;

import java.util.ArrayList;
import java.util.List;

import tec.mediTEC.medicResources.cita;

public class Doctor extends Registro{
	private String nombre;
	private String correo;
	private int codigo;
	private int calificacion = 5;
	private static List<cita> citas;//acá va a un árbol
	
	public Doctor(){
		this.codigo = super.numRandom();
		this.calificacion = 0;
		citas = new ArrayList<>();//árbol
		try{
			super.codigoQR(this.codigo);
		}catch(Exception e){
			System.out.print(e);
		}
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
		return calificacion;
	}

	public void setCalificación(int calificación) {
		this.calificacion = calificación;
	}
	
	
	

}
