package te.mediTEC.medicResources;

import java.util.ArrayList;
import java.util.List;

public class cita {
	private String paciente;
	private String doctor;
	private int codigo;
	private int cosTotal = 0;
	private boolean finalizado = false;
	private static List<String> sintomas;
	private static List<casoClinico> casosClinicos;
	private static List<examen> examenes;
	private static List<medic> medicamentos;
	
	public cita(){
		this.codigo = 555;
		casosClinicos = new ArrayList<>();
		examenes = new ArrayList<>();
		medicamentos = new ArrayList<>();
	}


	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
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

	public  List<casoClinico> getCasosClinicos() {
		return casosClinicos;
	}

	public  void setCasosClinicos(List<casoClinico> casosClinicos) {
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
	
	
	

}
