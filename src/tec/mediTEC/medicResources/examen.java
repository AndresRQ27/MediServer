package tec.mediTEC.medicResources;

public class examen {
	private String nombre;
	private int codigo;
	private int costo;
	
	public examen(){
		this.codigo = 4444;
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
