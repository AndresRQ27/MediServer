package tec.mediTEC.usuarios;

import java.util.ArrayList;
import java.util.List;

import tec.mediTEC.medicResources.cita;

public class Doctor extends Registro{
	private String nombre;
	private String correo;
	private int codigo;
	private int calificación = 5;
	private static List<cita> citas;
	
	public Doctor(){
		this.codigo = super.numRandom();
		this.calificación = 0;
		citas = new ArrayList<>();
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
		return calificación;
	}

	public void setCalificación(int calificación) {
		this.calificación = calificación;
	}
	
	
	

}
