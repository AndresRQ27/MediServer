package tec.mediTEC.medicResources;

import tec.mediTEC.usuarios.Registro;

public class medic extends Registro implements Comparable<medic>{
	private String nombre;
	private int codigo;
	private int costo;
	
	@Override
	public int compareTo(medic o) {
		return Integer.toString(this.codigo).compareTo(Integer.toString(o.getCodigo()));
	}
	public medic(){
		this.codigo = super.numRandom();
	}
	
	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
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
