package tec.mediTEC.usuarios;

import tec.mediTEC.trees.AVLTree;

public class Doctor extends Registro{
	private String nombre;
	private String correo;
	private int codigo;
	private int calificacion;
	private static AVLTree citas;//ac� va a un �rbol
	
	public Doctor(){
		this.codigo = super.numRandom();
		this.calificacion = 0;
		citas = new AVLTree();//�rbol
		try{
			super.codigoQR(this.codigo);
		}catch(Exception e){
			System.out.print(e);
		}
	}

	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public AVLTree getCitas() {
		return citas;
	}
	public void setCitas(AVLTree citas) {
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
