package tec.mediTEC.medicResources;

import tec.mediTEC.usuarios.Registro;

public class examen extends Registro{
	private String nombre;
	private int codigo;
	private int costo;
	
	public examen(){
		this.codigo = super.numRandom();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
