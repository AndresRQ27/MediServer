package Prueba;

public class paciente {
	private String nombre;
	private String cedula;
	
	public paciente(){
	}
	
	public paciente(String nombre, String cedula){
		this.nombre = nombre;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	

}
