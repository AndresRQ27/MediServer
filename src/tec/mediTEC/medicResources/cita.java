package tec.mediTEC.medicResources;

import java.util.ArrayList;
import java.util.List;

import tec.mediTEC.trees.AVLTree;
import tec.mediTEC.trees.BinaryTree;
import tec.mediTEC.usuarios.Registro;

public class cita extends Registro implements Comparable<cita>{
	private String paciente;
	private String fecha;
	private String sintomas;
	private int codigo;
	private int cosTotal = 0;
	private boolean finalizado = false;
	private static AVLTree<casoClinico> casosClinicos;
	private static BinaryTree<examen> examenes;
	private static BinaryTree<medic> medicamentos;
	
	
	@Override
	public int compareTo(cita o) {
		return Integer.toString(this.codigo).compareTo(Integer.toString(o.getCodigo()));
	}
	
	
	public cita(){
		this.codigo = super.numRandom();
		casosClinicos = new AVLTree<casoClinico>();
		examenes = new BinaryTree<examen>();
		medicamentos = new BinaryTree<medic>();
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public  String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		sintomas = sintomas;
	}

	public  AVLTree<casoClinico> getCasosClinicos() {
		return casosClinicos;
	}

	public void setCasosClinicos(AVLTree<casoClinico> casosClinicos) {
		cita.casosClinicos = casosClinicos;
	}


	public static BinaryTree<examen> getExamenes() {
		return examenes;
	}


	public static void setExamenes(BinaryTree<examen> examenes) {
		cita.examenes = examenes;
	}


	public static BinaryTree<medic> getMedicamentos() {
		return medicamentos;
	}


	public static void setMedicamentos(BinaryTree<medic> medicamentos) {
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
