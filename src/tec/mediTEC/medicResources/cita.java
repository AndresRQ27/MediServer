package tec.mediTEC.medicResources;

import java.util.ArrayList;
import java.util.List;

import tec.mediTEC.trees.AVLTree;
import tec.mediTEC.usuarios.Registro;

public class cita extends Registro{
	private String paciente;
	private String fecha;
	private int codigo;
	private int cosTotal = 0;
	private boolean finalizado = false;
	private static List<String> sintomas;
	private static AVLTree casosClinicos;
	private static List<examen> examenes;
	private static List<medic> medicamentos;
	
	public cita(){
		this.codigo = super.numRandom();
		casosClinicos = new AVLTree();
		examenes = new ArrayList<>();
		medicamentos = new ArrayList<>();
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public  List<String> getSintomas() {
		return sintomas;
	}

	public  void setSintomas(List<String> sintomas) {
		cita.sintomas = sintomas;
	}


	public  AVLTree getCasosClinicos() {
		return casosClinicos;
	}

	public void setCasosClinicos(AVLTree casosClinicos) {
		cita.casosClinicos = casosClinicos;
	}

	public  List<examen> getExamenes() {
		return examenes;
	}

	public  void setExamenes(List<examen> examenes) {
		cita.examenes = examenes;
	}

	public  List<medic> getMedicamentos() {
		return medicamentos;
	}

	public  void setMedicamentos(List<medic> medicamentos) {
		cita.medicamentos = medicamentos;
	}

	public int getCosTotal() {
		return cosTotal;
	}

	public void setCosTotal(int cosTotal) {
		this.cosTotal = cosTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	

}
