package te.mediTEC.medicResources;

public class medic {
	private String nombre;
	private int codigo;
	
	public medic(){
	}
	public medic(String nombre){
		this.nombre = nombre;
		this.codigo= 000;
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
