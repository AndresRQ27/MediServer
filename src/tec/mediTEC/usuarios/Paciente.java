package tec.mediTEC.usuarios;


public class Paciente extends Registro{
	private String nombre;
	private String correo;
	private int codigo;
	
	public Paciente(){
		this.codigo = super.numRandom();
		try{
			super.codigoQR(this.codigo);
		}catch(Exception e){
			System.out.print(e);
		}		
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
