package te.mediTEC.medicResources;

public class examen {
	private String nombre;
	private int codigo;
	
	public examen(){
	}
	public examen(String nombre){
		this.nombre = nombre;
		this.codigo = 333;
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
