package tec.mediTEC.usuarios;

public class Paciente {
	private int codigo;
	private String nombre;
	private String correo;
	
	public Paciente(){		
	}
	
	public Paciente(String nombre,String correo){
		this.nombre = nombre;
		this.correo = correo;
		this.codigo = 666;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	

}
