package te.mediTEC.medicResources;

import java.util.List;

public class casoClinico {
	private String nombre;
	private int codigo;
	private static List<examen> examenes;
	private static List<medic> medicamentos;
	
	public casoClinico(){
	}
	
	public casoClinico(String nombre,List<examen> examenes, List<medic> medicamentos){
		this.nombre = nombre;
		examenes = examenes;
		medicamentos = medicamentos;
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

	public  List<examen> getExamenes() {
		return examenes;
	}

	public  void setExamenes(List<examen> examenes) {
		casoClinico.examenes = examenes;
	}

	public  List<medic> getMedicamentos() {
		return medicamentos;
	}

	public  void setMedicamentos(List<medic> medicamentos) {
		casoClinico.medicamentos = medicamentos;
	}

}
