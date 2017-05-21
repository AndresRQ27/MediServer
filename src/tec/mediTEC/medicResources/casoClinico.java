package tec.mediTEC.medicResources;

import java.util.ArrayList;
import java.util.List;

import tec.mediTEC.usuarios.Registro;

public class casoClinico extends Registro{
	private String nombre;
	private int codigo;
	private static List<examen> examenes;
	private static List<medic> medicamentos;
	
	public casoClinico(){
		this.codigo = super.numRandom();
		examenes = new ArrayList<>();
		medicamentos = new ArrayList<>();
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
