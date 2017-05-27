package tec.mediTEC.usuarios;

import tec.mediTEC.medicResources.cita;
import tec.mediTEC.trees.AVLTree;

public class Doctor extends Registro implements Comparable<Doctor>{
	private String nombre;
	private String correo;
	private int codigo;
	private int calificacion;
	private static AVLTree<cita> citas;//acá va a un árbol
	

	public Doctor(){
		this.codigo = super.numRandom();
		this.calificacion = 0;
		citas = new AVLTree<cita>();//árbol
		try{
			super.codigoQR(this.codigo);
		}catch(Exception e){
			System.out.print(e);
		}
	}
	
	public Doctor(int id){
		this.codigo = id;
	}

	@Override
	public int compareTo(Doctor o) {
		return Integer.toString(this.codigo).compareTo(Integer.toString(o.getCodigo()));
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public AVLTree<cita> getCitas() {
		return citas;
	}
	public void setCitas(AVLTree<cita> citas) {
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
}
